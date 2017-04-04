import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {DashboardComponent} from "./dashboard.component";

export const DashboardRoutes: ModuleWithProviders = RouterModule.forChild(
  [
    {
      path: 'dashboard', component: DashboardComponent,
      data: {
        title: 'Dashboard',
        listable: true
      }
    }
  ] as Routes
);
