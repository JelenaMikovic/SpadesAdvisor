import { Component } from '@angular/core';

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

  restaurants: Restaurant[] = [
    {
      name: 'Gusto Italiano',
      cuisine_type: 0,
      location: 'Bulevar Oslobođenja 22, Stari Grad, Novi Sad',
      price: 2500.00,
      opening_hour: '12:00',
      closing_hour: '23:00',
      is_vegetarian_friendly: true,
      is_smoker_friendly: false,
    },
    {
      name: 'Great Wall',
      cuisine_type: 1,
      location: 'Bulevar Cara Lazara 18, Stari Grad, Novi Sad',
      price: 2000.00,
      opening_hour: '11:30',
      closing_hour: '22:30',
      is_vegetarian_friendly: true,
      is_smoker_friendly: false,
    },
    {
      name: 'El Mariachi',
      cuisine_type: 2,
      location: 'Bulevar Mihajla Pupina 3, Novo Naselje, Novi Sad',
      price: 1800.00,
      opening_hour: '11:00',
      closing_hour: '23:00',
      is_vegetarian_friendly: true,
      is_smoker_friendly: true,
    },
    {
      name: 'Gusto Italiano',
      cuisine_type: 0,
      location: 'Bulevar Oslobođenja 22, Stari Grad, Novi Sad',
      price: 2500.00,
      opening_hour: '12:00',
      closing_hour: '23:00',
      is_vegetarian_friendly: true,
      is_smoker_friendly: false,
    },
    {
      name: 'Great Wall',
      cuisine_type: 1,
      location: 'Bulevar Cara Lazara 18, Stari Grad, Novi Sad',
      price: 2000.00,
      opening_hour: '11:30',
      closing_hour: '22:30',
      is_vegetarian_friendly: true,
      is_smoker_friendly: false,
    }
  ];
}

interface Restaurant {
  name: string;
  cuisine_type: number;
  location: string;
  price: number;
  opening_hour: string;
  closing_hour: string;
  is_vegetarian_friendly: boolean;
  is_smoker_friendly: boolean;
}