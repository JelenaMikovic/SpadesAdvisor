import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    const loginData = {
      email: this.email,
      password: this.password
    };

    this.http.post('http://localhost:8080/api/users/login', loginData, { responseType: 'text', withCredentials: true}).subscribe(
      response => {
        console.log(response);
        alert('Login successful');
        this.router.navigate(['/home']);
      },
      error => {
        console.error(error);
        alert('Invalid email or password');
      }
    );
  }
}
