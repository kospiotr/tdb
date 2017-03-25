import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {DashboardComponent} from "./modules/dashboard/dashboard.component";
import {UsersComponent} from "./modules/users/users.component";

export const routes: Routes = [
  {
    path: 'dashboard', component: DashboardComponent, data: {
    title: 'Dashboard'
  }
  },
  {
    path: 'users', component: UsersComponent, data: {
    title: 'Users'
  }
  },
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes, {useHash: true});
