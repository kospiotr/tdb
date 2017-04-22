//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.spec.ts.e.vm
//
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserGroupListComponent } from './userGroupList.component';

describe('UserGroupListComponent', () => {
  let component: UserGroupListComponent;
  let fixture: ComponentFixture<UserGroupListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserGroupListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserGroupListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
