import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  firstName: string = '';
  lastName: string = '';
  phoneNumber: string = '';
  email: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    const registrationData = {
      firstName: this.firstName,
      lastName: this.lastName,
      phoneNumber: this.phoneNumber,
      email: this.email,
      password: this.password
    };

    this.http.post('http://localhost:8080/api/users/register', registrationData, {
      responseType: 'text' 
    }).subscribe(
      response => {
        console.log(response);
        alert('User registered successfully');
        this.router.navigate(['/login']);
      },
      error => {
        console.error(error);
        alert('Error during registration: ' + error.error);
      }
    );
  }
}
