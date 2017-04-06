//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {UsersListComponent} from "./usersList.component";
import {UsersComponent} from "./users.component";

export const routes: Routes = [
  {
    path: 'users', component: UsersListComponent,
    data: {
      title: 'Users list',
      listable: true
    }
  },
  {
    path: 'users/create', component: UsersComponent,
    data: {
      title: 'Users create'
    }
  },
  {
    path: 'users/:id', component: UsersComponent,
    data: {
      title: 'Users view'
    }
  },
  {
    path: 'users/:id/edit', component: UsersComponent,
    data: {
      title: 'Users edit'
    }
  },
  {
    path: 'users/:id/copy', component: UsersComponent,
    data: {
      title: 'Users copy'
    }
  }
];

export const UsersRoutes: ModuleWithProviders = RouterModule.forChild(routes);
