import {NgModule} from "@angular/core";
import {DashboardComponent} from "./dashboard.component";
import {DashboardRoutes} from "./dashboard.routes";
import {RouterModule} from "@angular/router";
import {SharedModule} from "../../shared/shared.module";


@NgModule({
  imports: [
    RouterModule,
    DashboardRoutes,
    SharedModule
  ],
  exports: [],
  declarations: [
    DashboardComponent
  ]
})
export class DashboardModule {
}
