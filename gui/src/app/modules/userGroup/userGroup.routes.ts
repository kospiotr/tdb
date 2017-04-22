//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {UserGroupListComponent} from "./userGroupList.component";
import {UserGroupComponent} from "./userGroup.component";

export const routes: Routes = [
  {
    path: 'userGroup', component: UserGroupListComponent,
    data: {
      title: 'UserGroup list',
      listable: true
    }
  },
  {
    path: 'userGroup/create', component: UserGroupComponent,
    data: {
      title: 'UserGroup create'
    }
  },
  {
    path: 'userGroup/:id', component: UserGroupComponent,
    data: {
      title: 'UserGroup view'
    }
  },
  {
    path: 'userGroup/:id/edit', component: UserGroupComponent,
    data: {
      title: 'UserGroup edit'
    }
  },
  {
    path: 'userGroup/:id/copy', component: UserGroupComponent,
    data: {
      title: 'UserGroup copy'
    }
  }
];

export const UserGroupRoutes: ModuleWithProviders = RouterModule.forChild(routes);
