//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {InstrumentComponent} from "./instrument.component";
import {InstrumentListComponent} from "./instrumentList.component";
import {InstrumentRoutes} from "./instrument.routes";
import {InstrumentResources} from "./instrument.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    InstrumentRoutes
  ],
  exports: [],
  declarations: [
    InstrumentComponent,
    InstrumentListComponent,
  ],
  providers:[
    InstrumentResources
  ]
})
export class InstrumentModule {
}
