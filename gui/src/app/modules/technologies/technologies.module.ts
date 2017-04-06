//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {TechnologiesComponent} from "./technologies.component";
import {TechnologiesListComponent} from "./technologiesList.component";
import {TechnologiesRoutes} from "./technologies.routes";
import {TechnologiesResources} from "./technologies.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    TechnologiesRoutes
  ],
  exports: [],
  declarations: [
    TechnologiesComponent,
    TechnologiesListComponent,
  ],
  providers:[
    TechnologiesResources
  ]
})
export class TechnologiesModule {
}
