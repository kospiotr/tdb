//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {LaboratoriesComponent} from "./laboratories.component";
import {LaboratoriesListComponent} from "./laboratoriesList.component";
import {LaboratoriesRoutes} from "./laboratories.routes";
import {LaboratoriesResources} from "./laboratories.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    LaboratoriesRoutes
  ],
  exports: [],
  declarations: [
    LaboratoriesComponent,
    LaboratoriesListComponent,
  ],
  providers:[
    LaboratoriesResources
  ]
})
export class LaboratoriesModule {
}
