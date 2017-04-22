//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {DatabasechangelogListComponent} from "./databasechangelogList.component";
import {DatabasechangelogComponent} from "./databasechangelog.component";

export const routes: Routes = [
  {
    path: 'databasechangelog', component: DatabasechangelogListComponent,
    data: {
      title: 'Databasechangelog list',
      listable: true
    }
  },
  {
    path: 'databasechangelog/create', component: DatabasechangelogComponent,
    data: {
      title: 'Databasechangelog create'
    }
  },
  {
    path: 'databasechangelog/:id', component: DatabasechangelogComponent,
    data: {
      title: 'Databasechangelog view'
    }
  },
  {
    path: 'databasechangelog/:id/edit', component: DatabasechangelogComponent,
    data: {
      title: 'Databasechangelog edit'
    }
  },
  {
    path: 'databasechangelog/:id/copy', component: DatabasechangelogComponent,
    data: {
      title: 'Databasechangelog copy'
    }
  }
];

export const DatabasechangelogRoutes: ModuleWithProviders = RouterModule.forChild(routes);
