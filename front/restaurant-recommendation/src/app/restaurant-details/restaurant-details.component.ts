import { Component } from '@angular/core';
import {RestaurantDataService} from "../restaurant-data.service";

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent {

  restaurant: any;

  constructor(private restaurantDataService: RestaurantDataService) {}

  ngOnInit(): void {
    this.restaurant = this.restaurantDataService.getRestaurantData();
  }

}
