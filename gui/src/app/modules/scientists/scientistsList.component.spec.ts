//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.spec.ts.e.vm
//
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScientistsListComponent } from './scientistsList.component';

describe('ScientistsListComponent', () => {
  let component: ScientistsListComponent;
  let fixture: ComponentFixture<ScientistsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScientistsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScientistsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
