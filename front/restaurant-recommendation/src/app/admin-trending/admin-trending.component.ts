import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-trending',
  templateUrl: './admin-trending.component.html',
  styleUrls: ['./admin-trending.component.css']
})
export class AdminTrendingComponent {
  filterData = {
    minRestaurantRating: null,
    minReviewsInPastMonth: null,
    desiredCuisineType: ''
  };

  constructor(private http: HttpClient) {}

  submitForm() {
    this.http.post('http://localhost:8080/api/restaurants/tempalate', this.filterData, {withCredentials: true})
      .subscribe(
        (response) => {
          console.log('Form data sent successfully!', response);
        },
        (error) => {
          console.error('Error sending form data:', error);
        }
      );
  }
}
