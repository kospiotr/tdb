//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {ScientistsComponent} from "./scientists.component";
import {ScientistsListComponent} from "./scientistsList.component";
import {ScientistsRoutes} from "./scientists.routes";
import {ScientistsResources} from "./scientists.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    ScientistsRoutes
  ],
  exports: [],
  declarations: [
    ScientistsComponent,
    ScientistsListComponent,
  ],
  providers:[
    ScientistsResources
  ]
})
export class ScientistsModule {
}
