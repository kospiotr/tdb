//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {ResearchListComponent} from "./researchList.component";
import {ResearchComponent} from "./research.component";

export const routes: Routes = [
  {
    path: 'research', component: ResearchListComponent,
    data: {
      title: 'Research list',
      listable: true
    }
  },
  {
    path: 'research/create', component: ResearchComponent,
    data: {
      title: 'Research create'
    }
  },
  {
    path: 'research/:id', component: ResearchComponent,
    data: {
      title: 'Research view'
    }
  },
  {
    path: 'research/:id/edit', component: ResearchComponent,
    data: {
      title: 'Research edit'
    }
  },
  {
    path: 'research/:id/copy', component: ResearchComponent,
    data: {
      title: 'Research copy'
    }
  }
];

export const ResearchRoutes: ModuleWithProviders = RouterModule.forChild(routes);
