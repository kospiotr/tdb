//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {PermissionListComponent} from "./permissionList.component";
import {PermissionComponent} from "./permission.component";

export const routes: Routes = [
  {
    path: 'permission', component: PermissionListComponent,
    data: {
      title: 'Permission list',
      listable: true
    }
  },
  {
    path: 'permission/create', component: PermissionComponent,
    data: {
      title: 'Permission create'
    }
  },
  {
    path: 'permission/:id', component: PermissionComponent,
    data: {
      title: 'Permission view'
    }
  },
  {
    path: 'permission/:id/edit', component: PermissionComponent,
    data: {
      title: 'Permission edit'
    }
  },
  {
    path: 'permission/:id/copy', component: PermissionComponent,
    data: {
      title: 'Permission copy'
    }
  }
];

export const PermissionRoutes: ModuleWithProviders = RouterModule.forChild(routes);
