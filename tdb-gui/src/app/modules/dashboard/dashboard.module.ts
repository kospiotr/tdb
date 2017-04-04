import {NgModule} from "@angular/core";
import {DashboardComponent} from "./dashboard.component";
import {DashboardRoutes} from "./dashboard.routes";


@NgModule({
  imports: [
    DashboardRoutes
  ],
  exports: [],
  declarations: [
    DashboardComponent
  ]
})
export class DashboardModule {
}
