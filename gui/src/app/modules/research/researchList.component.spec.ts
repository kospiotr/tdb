//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.spec.ts.e.vm
//
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResearchListComponent } from './researchList.component';

describe('ResearchListComponent', () => {
  let component: ResearchListComponent;
  let fixture: ComponentFixture<ResearchListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResearchListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResearchListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
