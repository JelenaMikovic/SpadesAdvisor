import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegistrationComponent } from './registration/registration.component';
import { FilteredRestaurantsComponent } from './filtered-restaurants/filtered-restaurants.component';
import { SearchedRestaurantsComponent } from './searched-restaurants/searched-restaurants.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'home', component: HomePageComponent },
  { path: 'filtered-restaurants', component: FilteredRestaurantsComponent },
  { path: 'searched-restaurants', component: SearchedRestaurantsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
