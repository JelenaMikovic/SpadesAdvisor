import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-filter-dialog',
  templateUrl: './filter-dialog.component.html',
  styleUrls: ['./filter-dialog.component.css']
})
export class FilterDialogComponent {
  filterData: any = {
    isSmokerFriendly: null,
    isVegetarianFriendly: null,
    location: null,
    cuisineType: null,
    minPrice: 0,
    maxPrice: null,
    minAvgRating: null
  };

  constructor(
    private dialogRef: MatDialogRef<FilterDialogComponent>,
    private router: Router
  ) {}

  applyFilters() {
    this.dialogRef.close(this.filterData);
    this.router.navigate(['/filtered-restaurants'], { queryParams: this.filterData });
  }
}
