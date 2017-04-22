//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {DepartmentComponent} from "./department.component";
import {DepartmentListComponent} from "./departmentList.component";
import {DepartmentRoutes} from "./department.routes";
import {DepartmentResources} from "./department.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    DepartmentRoutes
  ],
  exports: [],
  declarations: [
    DepartmentComponent,
    DepartmentListComponent,
  ],
  providers:[
    DepartmentResources
  ]
})
export class DepartmentModule {
}
