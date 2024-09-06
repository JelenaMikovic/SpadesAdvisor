import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
  user: UserInfoDTO | null = null;  // Promenljiva za čuvanje podataka o korisniku
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.getUserData().subscribe(
      (data: UserInfoDTO) => {
        console.log(data)
        this.user = data;  // Podaci se učitavaju u promenljivu 'user'
      },
      (error: any) => {
        console.error('Greška prilikom učitavanja podataka o korisniku:', error);
      }
    );
  }

  // Metoda koja poziva backend API i vraća Observable sa podacima o korisniku
  getUserData(): Observable<UserInfoDTO> {
    const apiUrl = 'http://localhost:8080/api/users/info';  // Zamenite sa pravim URL-om vašeg API-ja
    return this.http.get<UserInfoDTO>(apiUrl, { withCredentials: true });
  }

}

// Definišemo UserRegistrationDTO interfejs
export interface UserInfoDTO {
  firstName: string;
  lastName: string;
  phoneNumber: string;
  email: string;
}
