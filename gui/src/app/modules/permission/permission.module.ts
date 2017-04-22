//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {PermissionComponent} from "./permission.component";
import {PermissionListComponent} from "./permissionList.component";
import {PermissionRoutes} from "./permission.routes";
import {PermissionResources} from "./permission.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    PermissionRoutes
  ],
  exports: [],
  declarations: [
    PermissionComponent,
    PermissionListComponent,
  ],
  providers:[
    PermissionResources
  ]
})
export class PermissionModule {
}
