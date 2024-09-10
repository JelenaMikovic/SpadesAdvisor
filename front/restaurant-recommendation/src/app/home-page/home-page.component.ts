import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {RestaurantDataService} from "../restaurant-data.service";
import {AppRoutingModule} from "../app-routing.module";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent {

  cuisineTypes = [
    'ITALIAN',
    'CHINESE',
    'MEXICAN',
    'AMERICAN',
    'FRENCH',
    'JAPANESE',
    'INDIAN',
    'THAI',
    'GREEK',
    'SERBIAN',
    'OTHER'
  ];

  restaurants: any[] = [];
  restaurantsRating: any[] = [];
  restaurantsLocation: any[] = [];
  topPicks: any[] = [];
  restaurantsPrice: any[] = [];
  reviewTopPicks: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private restaurantDataService: RestaurantDataService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getRecommended();
  }


  getRecommended() {
    this.http.get<any>('http://localhost:8080/api/restaurants/reccomended', { withCredentials: true })
      .subscribe(
        (data: any) => {
          console.log(data);
          this.restaurantsRating = data.recommendedRestaurantsRating || [];
          this.restaurantsLocation = data.recommendedRestaurantsLocation || [];
          this.restaurantsPrice = data.recommendedRestaurantsPrice || [];
        },
        (error: any) => {
          console.error('Error fetching recommended restaurants', error);
        }
      );
    this.http.get<any>('http://localhost:8080/api/restaurants/top-picks', { withCredentials: true })
      .subscribe(
        (data: any) => {
          console.log(data);
          this.topPicks = data;
        },
        (error: any) => {
          console.error('Error fetching recommended restaurants', error);
        }
      );
      this.http.get<any>('http://localhost:8080/api/restaurants/trendning')
      .subscribe(
        (data: any) => {
          console.log(data);
          this.restaurants = data;
        },
        (error: any) => {
          console.error('Error fetching recommended restaurants', error);
        }
      );
    this.http.get<any>('http://localhost:8080/api/restaurants/review-top-picks')
      .subscribe(
        (data: any) => {
          console.log(data);
          this.reviewTopPicks = data;
        },
        (error: any) => {
          console.error('Error fetching review recommended restaurants', error);
        }
      );
  }

  onCardClick(restaurant: any) {
    this.restaurantDataService.setRestaurantData(restaurant);
    this.router.navigate(['/restaurant-details']); // Adjust the route if necessary
  }
}
