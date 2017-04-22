//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {DatabasechangelogComponent} from "./databasechangelog.component";
import {DatabasechangelogListComponent} from "./databasechangelogList.component";
import {DatabasechangelogRoutes} from "./databasechangelog.routes";
import {DatabasechangelogResources} from "./databasechangelog.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    DatabasechangelogRoutes
  ],
  exports: [],
  declarations: [
    DatabasechangelogComponent,
    DatabasechangelogListComponent,
  ],
  providers:[
    DatabasechangelogResources
  ]
})
export class DatabasechangelogModule {
}
