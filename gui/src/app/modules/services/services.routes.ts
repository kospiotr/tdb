//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {ServicesListComponent} from "./servicesList.component";
import {ServicesComponent} from "./services.component";

export const routes: Routes = [
  {
    path: 'services', component: ServicesListComponent,
    data: {
      title: 'Services list',
      listable: true
    }
  },
  {
    path: 'services/create', component: ServicesComponent,
    data: {
      title: 'Services create'
    }
  },
  {
    path: 'services/:id', component: ServicesComponent,
    data: {
      title: 'Services view'
    }
  },
  {
    path: 'services/:id/edit', component: ServicesComponent,
    data: {
      title: 'Services edit'
    }
  },
  {
    path: 'services/:id/copy', component: ServicesComponent,
    data: {
      title: 'Services copy'
    }
  }
];

export const ServicesRoutes: ModuleWithProviders = RouterModule.forChild(routes);
