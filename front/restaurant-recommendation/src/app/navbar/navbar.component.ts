import { Component } from '@angular/core';
import { FilterDialogComponent } from '../filter-dialog/filter-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  
  constructor(public dialog: MatDialog, private http: HttpClient, private router: Router) {}

  openFilterDialog(): void {
    this.dialog.open(FilterDialogComponent, {
      width: '400px'
    });
  }

  logout() {
    this.http.post('http://localhost:8080/api/users/logout', {}, {
      withCredentials: true,
      responseType: 'text' // Explicitly set the response type to text
    }).subscribe(
      response => {
        console.log(response);
        alert('Logout successful');
        this.router.navigate(['/login']); // Redirect to login or another route
      },
      error => {
        console.error(error);
        alert('Error during logout');
      }
    );
  }
  
}
