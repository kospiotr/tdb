//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {UsersComponent} from "./users.component";
import {UsersListComponent} from "./usersList.component";
import {UsersRoutes} from "./users.routes";
import {UsersResources} from "./users.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    UsersRoutes
  ],
  exports: [],
  declarations: [
    UsersComponent,
    UsersListComponent,
  ],
  providers:[
    UsersResources
  ]
})
export class UsersModule {
}
