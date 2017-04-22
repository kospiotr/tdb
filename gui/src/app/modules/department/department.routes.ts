//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {DepartmentListComponent} from "./departmentList.component";
import {DepartmentComponent} from "./department.component";

export const routes: Routes = [
  {
    path: 'department', component: DepartmentListComponent,
    data: {
      title: 'Department list',
      listable: true
    }
  },
  {
    path: 'department/create', component: DepartmentComponent,
    data: {
      title: 'Department create'
    }
  },
  {
    path: 'department/:id', component: DepartmentComponent,
    data: {
      title: 'Department view'
    }
  },
  {
    path: 'department/:id/edit', component: DepartmentComponent,
    data: {
      title: 'Department edit'
    }
  },
  {
    path: 'department/:id/copy', component: DepartmentComponent,
    data: {
      title: 'Department copy'
    }
  }
];

export const DepartmentRoutes: ModuleWithProviders = RouterModule.forChild(routes);
