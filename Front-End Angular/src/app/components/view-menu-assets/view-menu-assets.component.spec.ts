import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMenuAssetsComponent } from './view-menu-assets.component';

describe('ViewMenuAssetsComponent', () => {
  let component: ViewMenuAssetsComponent;
  let fixture: ComponentFixture<ViewMenuAssetsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMenuAssetsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMenuAssetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
