//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {DepartmentUnitComponent} from "./departmentUnit.component";
import {DepartmentUnitListComponent} from "./departmentUnitList.component";
import {DepartmentUnitRoutes} from "./departmentUnit.routes";
import {DepartmentUnitResources} from "./departmentUnit.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    DepartmentUnitRoutes
  ],
  exports: [],
  declarations: [
    DepartmentUnitComponent,
    DepartmentUnitListComponent,
  ],
  providers:[
    DepartmentUnitResources
  ]
})
export class DepartmentUnitModule {
}
