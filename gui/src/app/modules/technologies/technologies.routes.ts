//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {TechnologiesListComponent} from "./technologiesList.component";
import {TechnologiesComponent} from "./technologies.component";

export const routes: Routes = [
  {
    path: 'technologies', component: TechnologiesListComponent,
    data: {
      title: 'Technologies list',
      listable: true
    }
  },
  {
    path: 'technologies/create', component: TechnologiesComponent,
    data: {
      title: 'Technologies create'
    }
  },
  {
    path: 'technologies/:id', component: TechnologiesComponent,
    data: {
      title: 'Technologies view'
    }
  },
  {
    path: 'technologies/:id/edit', component: TechnologiesComponent,
    data: {
      title: 'Technologies edit'
    }
  },
  {
    path: 'technologies/:id/copy', component: TechnologiesComponent,
    data: {
      title: 'Technologies copy'
    }
  }
];

export const TechnologiesRoutes: ModuleWithProviders = RouterModule.forChild(routes);
