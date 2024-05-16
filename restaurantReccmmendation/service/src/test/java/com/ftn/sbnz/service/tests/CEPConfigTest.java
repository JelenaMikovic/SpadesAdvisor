package com.ftn.sbnz.service.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.drools.compiler.kie.builder.impl.KieContainerImpl;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.time.SessionPseudoClock;
import org.kie.internal.command.CommandFactory;

import com.ftn.sbnz.model.models.CuisineType;
import com.ftn.sbnz.model.models.Restaurant;
import com.ftn.sbnz.model.models.Review;
import com.ftn.sbnz.model.models.User;


public class CEPConfigTest {

    @Test
    public void testRecommendedRestaurants() {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("cepKsession");
        SessionPseudoClock clock = ksession.getSessionClock();

        User user = new User();

        Restaurant visit1 = new Restaurant(1, CuisineType.ITALIAN, "Location 1", 20.0, "12:00", "22:00", true, false);
        Restaurant visit2 = new Restaurant(2, CuisineType.CHINESE, "Location 2", 25.0, "11:30", "21:30", false, true);
        Review review1 = new Review(1, user, visit1, 4);
        Review review2 = new Review(2, user, visit2, 5);

        List<Restaurant> allRestaurants = new ArrayList<>();
        allRestaurants.add(visit1);
        allRestaurants.add(visit2);
        allRestaurants.add(new Restaurant(3, CuisineType.ITALIAN, "Location 3", 30.0, "11:00", "23:00", true, true));
        ksession.setGlobal("allRestaurants", allRestaurants);
        ksession.setGlobal("recommendations", new ArrayList<>());

        ksession.insert(review1);
        clock.advanceTime(5, java.util.concurrent.TimeUnit.DAYS);
        ksession.insert(review2);

        ksession.fireAllRules();

        List<Restaurant> recommendedRestaurants = (List<Restaurant>) ksession.getGlobal("recommendations");

        assertEquals(0, recommendedRestaurants.size());
    }
}
