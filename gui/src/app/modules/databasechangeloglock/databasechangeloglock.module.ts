//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {DatabasechangeloglockComponent} from "./databasechangeloglock.component";
import {DatabasechangeloglockListComponent} from "./databasechangeloglockList.component";
import {DatabasechangeloglockRoutes} from "./databasechangeloglock.routes";
import {DatabasechangeloglockResources} from "./databasechangeloglock.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    DatabasechangeloglockRoutes
  ],
  exports: [],
  declarations: [
    DatabasechangeloglockComponent,
    DatabasechangeloglockListComponent,
  ],
  providers:[
    DatabasechangeloglockResources
  ]
})
export class DatabasechangeloglockModule {
}
