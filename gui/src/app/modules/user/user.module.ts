//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {UserComponent} from "./user.component";
import {UserListComponent} from "./userList.component";
import {UserRoutes} from "./user.routes";
import {UserResources} from "./user.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    UserRoutes
  ],
  exports: [],
  declarations: [
    UserComponent,
    UserListComponent,
  ],
  providers:[
    UserResources
  ]
})
export class UserModule {
}
