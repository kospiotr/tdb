//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {LaboratoriesListComponent} from "./laboratoriesList.component";
import {LaboratoriesComponent} from "./laboratories.component";

export const routes: Routes = [
  {
    path: 'laboratories', component: LaboratoriesListComponent,
    data: {
      title: 'Laboratories list',
      listable: true
    }
  },
  {
    path: 'laboratories/create', component: LaboratoriesComponent,
    data: {
      title: 'Laboratories create'
    }
  },
  {
    path: 'laboratories/:id', component: LaboratoriesComponent,
    data: {
      title: 'Laboratories view'
    }
  },
  {
    path: 'laboratories/:id/edit', component: LaboratoriesComponent,
    data: {
      title: 'Laboratories edit'
    }
  },
  {
    path: 'laboratories/:id/copy', component: LaboratoriesComponent,
    data: {
      title: 'Laboratories copy'
    }
  }
];

export const LaboratoriesRoutes: ModuleWithProviders = RouterModule.forChild(routes);
