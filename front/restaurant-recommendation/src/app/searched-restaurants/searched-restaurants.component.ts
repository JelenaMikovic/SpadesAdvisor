import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-searched-restaurants',
  templateUrl: './searched-restaurants.component.html',
  styleUrls: ['./searched-restaurants.component.css']
})
export class SearchedRestaurantsComponent {
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
  searchData: any = '';

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.searchData = params;
      this.getFilteredRestaurants();
    });
  }

  getFilteredRestaurants() {
    console.log(this.searchData)
    this.http.get<any[]>(`http://localhost:8080/api/restaurants/search?name=${this.searchData.name}`)
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
