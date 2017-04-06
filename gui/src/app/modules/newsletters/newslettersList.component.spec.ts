//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.spec.ts.e.vm
//
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewslettersListComponent } from './newslettersList.component';

describe('NewslettersListComponent', () => {
  let component: NewslettersListComponent;
  let fixture: ComponentFixture<NewslettersListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewslettersListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewslettersListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
