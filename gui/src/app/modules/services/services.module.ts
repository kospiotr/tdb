//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {ServicesComponent} from "./services.component";
import {ServicesListComponent} from "./servicesList.component";
import {ServicesRoutes} from "./services.routes";
import {ServicesResources} from "./services.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    ServicesRoutes
  ],
  exports: [],
  declarations: [
    ServicesComponent,
    ServicesListComponent,
  ],
  providers:[
    ServicesResources
  ]
})
export class ServicesModule {
}
