//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {UserGroupComponent} from "./userGroup.component";
import {UserGroupListComponent} from "./userGroupList.component";
import {UserGroupRoutes} from "./userGroup.routes";
import {UserGroupResources} from "./userGroup.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    UserGroupRoutes
  ],
  exports: [],
  declarations: [
    UserGroupComponent,
    UserGroupListComponent,
  ],
  providers:[
    UserGroupResources
  ]
})
export class UserGroupModule {
}
