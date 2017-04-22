//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {DatabasechangeloglockListComponent} from "./databasechangeloglockList.component";
import {DatabasechangeloglockComponent} from "./databasechangeloglock.component";

export const routes: Routes = [
  {
    path: 'databasechangeloglock', component: DatabasechangeloglockListComponent,
    data: {
      title: 'Databasechangeloglock list',
      listable: true
    }
  },
  {
    path: 'databasechangeloglock/create', component: DatabasechangeloglockComponent,
    data: {
      title: 'Databasechangeloglock create'
    }
  },
  {
    path: 'databasechangeloglock/:id', component: DatabasechangeloglockComponent,
    data: {
      title: 'Databasechangeloglock view'
    }
  },
  {
    path: 'databasechangeloglock/:id/edit', component: DatabasechangeloglockComponent,
    data: {
      title: 'Databasechangeloglock edit'
    }
  },
  {
    path: 'databasechangeloglock/:id/copy', component: DatabasechangeloglockComponent,
    data: {
      title: 'Databasechangeloglock copy'
    }
  }
];

export const DatabasechangeloglockRoutes: ModuleWithProviders = RouterModule.forChild(routes);
