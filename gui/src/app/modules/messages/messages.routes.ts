//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {MessagesListComponent} from "./messagesList.component";
import {MessagesComponent} from "./messages.component";

export const routes: Routes = [
  {
    path: 'messages', component: MessagesListComponent,
    data: {
      title: 'Messages list',
      listable: true
    }
  },
  {
    path: 'messages/create', component: MessagesComponent,
    data: {
      title: 'Messages create'
    }
  },
  {
    path: 'messages/:id', component: MessagesComponent,
    data: {
      title: 'Messages view'
    }
  },
  {
    path: 'messages/:id/edit', component: MessagesComponent,
    data: {
      title: 'Messages edit'
    }
  },
  {
    path: 'messages/:id/copy', component: MessagesComponent,
    data: {
      title: 'Messages copy'
    }
  }
];

export const MessagesRoutes: ModuleWithProviders = RouterModule.forChild(routes);
