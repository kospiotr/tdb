//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.spec.ts.e.vm
//
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaboratoriesComponent } from './laboratories.component';

describe('LaboratoriesComponent', () => {
  let component: LaboratoriesComponent;
  let fixture: ComponentFixture<LaboratoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaboratoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaboratoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
