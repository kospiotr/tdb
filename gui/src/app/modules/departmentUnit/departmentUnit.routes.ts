//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {DepartmentUnitListComponent} from "./departmentUnitList.component";
import {DepartmentUnitComponent} from "./departmentUnit.component";

export const routes: Routes = [
  {
    path: 'departmentUnit', component: DepartmentUnitListComponent,
    data: {
      title: 'DepartmentUnit list',
      listable: true
    }
  },
  {
    path: 'departmentUnit/create', component: DepartmentUnitComponent,
    data: {
      title: 'DepartmentUnit create'
    }
  },
  {
    path: 'departmentUnit/:id', component: DepartmentUnitComponent,
    data: {
      title: 'DepartmentUnit view'
    }
  },
  {
    path: 'departmentUnit/:id/edit', component: DepartmentUnitComponent,
    data: {
      title: 'DepartmentUnit edit'
    }
  },
  {
    path: 'departmentUnit/:id/copy', component: DepartmentUnitComponent,
    data: {
      title: 'DepartmentUnit copy'
    }
  }
];

export const DepartmentUnitRoutes: ModuleWithProviders = RouterModule.forChild(routes);
