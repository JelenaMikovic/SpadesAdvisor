import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
  favoriteRestaurants: { name: string, count: number }[] = [];
  favoriteCuisine: { cuisine: string, count: number }[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getFavoriteRestaurants();
    this.getFavoriteCuisine();
  }

  getFavoriteRestaurants() {
    this.http.get<{ [key: string]: number }>('http://localhost:8080/api/report/favorite-restaurants', { withCredentials: true })
      .subscribe(data => {
        this.favoriteRestaurants = Object.keys(data).map(key => ({ name: key, count: data[key] }));
      });
  }

  getFavoriteCuisine() {
    this.http.get<{ [key: string]: number }>('http://localhost:8080/api/report/favorite-cuisine', { withCredentials: true })
      .subscribe(data => {
        this.favoriteCuisine = Object.keys(data).map(key => ({ cuisine: key, count: data[key] }));
      });
  }
}
