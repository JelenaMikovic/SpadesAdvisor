import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

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

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient
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
  }
}
