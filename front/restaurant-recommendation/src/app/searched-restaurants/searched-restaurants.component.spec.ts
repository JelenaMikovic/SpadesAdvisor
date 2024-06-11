import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchedRestaurantsComponent } from './searched-restaurants.component';

describe('SearchedRestaurantsComponent', () => {
  let component: SearchedRestaurantsComponent;
  let fixture: ComponentFixture<SearchedRestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchedRestaurantsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchedRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
