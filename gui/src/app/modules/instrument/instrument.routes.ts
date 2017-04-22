//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.routes.ts.e.vm
//
import {Routes, RouterModule} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {InstrumentListComponent} from "./instrumentList.component";
import {InstrumentComponent} from "./instrument.component";

export const routes: Routes = [
  {
    path: 'instrument', component: InstrumentListComponent,
    data: {
      title: 'Instrument list',
      listable: true
    }
  },
  {
    path: 'instrument/create', component: InstrumentComponent,
    data: {
      title: 'Instrument create'
    }
  },
  {
    path: 'instrument/:id', component: InstrumentComponent,
    data: {
      title: 'Instrument view'
    }
  },
  {
    path: 'instrument/:id/edit', component: InstrumentComponent,
    data: {
      title: 'Instrument edit'
    }
  },
  {
    path: 'instrument/:id/copy', component: InstrumentComponent,
    data: {
      title: 'Instrument copy'
    }
  }
];

export const InstrumentRoutes: ModuleWithProviders = RouterModule.forChild(routes);
