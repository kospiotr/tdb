//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {UserListComponent} from "./userList.component";
import {UserComponent} from "./user.component";

export const routes: Routes = [
  {
    path: 'user', component: UserListComponent,
    data: {
      title: 'User list',
      listable: true
    }
  },
  {
    path: 'user/create', component: UserComponent,
    data: {
      title: 'User create'
    }
  },
  {
    path: 'user/:id', component: UserComponent,
    data: {
      title: 'User view'
    }
  },
  {
    path: 'user/:id/edit', component: UserComponent,
    data: {
      title: 'User edit'
    }
  },
  {
    path: 'user/:id/copy', component: UserComponent,
    data: {
      title: 'User copy'
    }
  }
];

export const UserRoutes: ModuleWithProviders = RouterModule.forChild(routes);
