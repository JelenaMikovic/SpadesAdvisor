import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-filtered-restaurants',
  templateUrl: './filtered-restaurants.component.html',
  styleUrls: ['./filtered-restaurants.component.css']
})
export class FilteredRestaurantsComponent implements OnInit {

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
  filterData: any = {};

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.filterData = params;
      this.getFilteredRestaurants();
    });
  }

  getFilteredRestaurants() {
    this.http.post<any[]>('http://localhost:8080/api/restaurants/filtered', this.filterData)
      .subscribe(
        data => {
          this.restaurants = data;
        },
        error => {
          console.error('Error fetching filtered restaurants', error);
        }
      );
  }
}
