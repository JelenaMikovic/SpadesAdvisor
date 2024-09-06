import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import { HttpClient } from '@angular/common/http';  // Uveri se da je HttpClient importovan


@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent {
  editProfileForm: FormGroup;  // Definisanje svojstva

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private http: HttpClient
  ) {
    this.editProfileForm = this.fb.group({});  // Inicijalizacija forme u konstruktoru
  }

  ngOnInit(): void {
    this.initForm();   // Inicijalizacija forme na inicijalizaciji komponente
    this.loadUserData();  // Učitavanje trenutnih podataka korisnika
  }

  initForm() {
    // Inicijalizacija formi sa validatorima
    this.editProfileForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required]
    });
  }

  loadUserData() {
    // HTTP GET zahtev za preuzimanje trenutnih korisničkih podataka
    this.http.get<any>('http://localhost:8080/api/users/info', { withCredentials: true }).subscribe(
      user => {
        if (user) {
          // Popunjavanje forme sa trenutnim podacima
          this.editProfileForm.patchValue({
            firstName: user.firstName,
            lastName: user.lastName,
            email: user.email,
            phoneNumber: user.phoneNumber
          });
        }
      },
      error => {
        console.error('Greška prilikom učitavanja podataka korisnika:', error);
        alert('Nije moguće učitati podatke korisnika');
      }
    );
  }

  onSubmit() {
    if (this.editProfileForm.valid) {
      // Preuzimanje izmenjenih podataka iz forme
      const updatedUserData = this.editProfileForm.value;
      console.log(updatedUserData);
      // HTTP PUT zahtev za ažuriranje korisničkih podataka
      this.http.put('http://localhost:8080/api/users/update', updatedUserData, {withCredentials: true, responseType: 'json'}).subscribe(
        response => {
          console.log(response);
          alert('Profil uspešno ažuriran');
          this.router.navigate(['/profile']);  // Redirekcija nakon uspešnog ažuriranja
        },
        error => {
          console.error(error);
          alert('Došlo je do greške prilikom ažuriranja profila');
        }
      );
    }
  }
}
