//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {NewslettersListComponent} from "./newslettersList.component";
import {NewslettersComponent} from "./newsletters.component";

export const routes: Routes = [
  {
    path: 'newsletters', component: NewslettersListComponent,
    data: {
      title: 'Newsletters list',
      listable: true
    }
  },
  {
    path: 'newsletters/create', component: NewslettersComponent,
    data: {
      title: 'Newsletters create'
    }
  },
  {
    path: 'newsletters/:id', component: NewslettersComponent,
    data: {
      title: 'Newsletters view'
    }
  },
  {
    path: 'newsletters/:id/edit', component: NewslettersComponent,
    data: {
      title: 'Newsletters edit'
    }
  },
  {
    path: 'newsletters/:id/copy', component: NewslettersComponent,
    data: {
      title: 'Newsletters copy'
    }
  }
];

export const NewslettersRoutes: ModuleWithProviders = RouterModule.forChild(routes);
