import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestaurantDataService {
  private restaurant: any;

  setRestaurantData(data: any) {
    this.restaurant = data;
  }

  getRestaurantData() {
    return this.restaurant;
  }

  constructor() { }
}
