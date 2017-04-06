//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {ScientistsListComponent} from "./scientistsList.component";
import {ScientistsComponent} from "./scientists.component";

export const routes: Routes = [
  {
    path: 'scientists', component: ScientistsListComponent,
    data: {
      title: 'Scientists list',
      listable: true
    }
  },
  {
    path: 'scientists/create', component: ScientistsComponent,
    data: {
      title: 'Scientists create'
    }
  },
  {
    path: 'scientists/:id', component: ScientistsComponent,
    data: {
      title: 'Scientists view'
    }
  },
  {
    path: 'scientists/:id/edit', component: ScientistsComponent,
    data: {
      title: 'Scientists edit'
    }
  },
  {
    path: 'scientists/:id/copy', component: ScientistsComponent,
    data: {
      title: 'Scientists copy'
    }
  }
];

export const ScientistsRoutes: ModuleWithProviders = RouterModule.forChild(routes);
