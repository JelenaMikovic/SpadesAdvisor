import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegistrationComponent } from './registration/registration.component';
import { FilteredRestaurantsComponent } from './filtered-restaurants/filtered-restaurants.component';
import { SearchedRestaurantsComponent } from './searched-restaurants/searched-restaurants.component';
import { ReportsComponent } from './reports/reports.component';
import { AdminTrendingComponent } from './admin-trending/admin-trending.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'home', component: HomePageComponent },
  { path: 'filtered-restaurants', component: FilteredRestaurantsComponent },
  { path: 'searched-restaurants', component: SearchedRestaurantsComponent },
  { path: 'reports', component: ReportsComponent },
  { path: 'template', component: AdminTrendingComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
