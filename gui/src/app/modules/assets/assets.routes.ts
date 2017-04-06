//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {AssetsListComponent} from "./assetsList.component";
import {AssetsComponent} from "./assets.component";

export const routes: Routes = [
  {
    path: 'assets', component: AssetsListComponent,
    data: {
      title: 'Assets list',
      listable: true
    }
  },
  {
    path: 'assets/create', component: AssetsComponent,
    data: {
      title: 'Assets create'
    }
  },
  {
    path: 'assets/:id', component: AssetsComponent,
    data: {
      title: 'Assets view'
    }
  },
  {
    path: 'assets/:id/edit', component: AssetsComponent,
    data: {
      title: 'Assets edit'
    }
  },
  {
    path: 'assets/:id/copy', component: AssetsComponent,
    data: {
      title: 'Assets copy'
    }
  }
];

export const AssetsRoutes: ModuleWithProviders = RouterModule.forChild(routes);
