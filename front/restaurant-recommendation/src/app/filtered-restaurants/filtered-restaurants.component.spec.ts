import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilteredRestaurantsComponent } from './filtered-restaurants.component';

describe('FilteredRestaurantsComponent', () => {
  let component: FilteredRestaurantsComponent;
  let fixture: ComponentFixture<FilteredRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilteredRestaurantsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FilteredRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
