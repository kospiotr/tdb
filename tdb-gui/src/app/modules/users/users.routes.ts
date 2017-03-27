import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {UsersComponent} from "./users.component";
import {UserComponent} from "./user.component";

export const routes: Routes = [
  {
    path: 'users', component: UsersComponent,
    data: {
      title: 'Users'
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

export const UsersRoutes: ModuleWithProviders = RouterModule.forChild(routes);
