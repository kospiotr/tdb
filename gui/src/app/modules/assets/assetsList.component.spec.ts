//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.spec.ts.e.vm
//
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssetsListComponent } from './assetsList.component';

describe('AssetsListComponent', () => {
  let component: AssetsListComponent;
  let fixture: ComponentFixture<AssetsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssetsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssetsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
