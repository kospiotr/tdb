import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {LayoutComponent} from "./shared/layout/layout.component";
import {AppRoutes} from "./app.routes";
import {DashboardComponent} from "./modules/dashboard/dashboard.component";
import {UsersDao} from "./modules/users/user.dao";
import {MenuComponent} from "./shared/menu/menu.component";
import {modules} from "./modules/modules";

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    MenuComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutes
  ].concat(modules),
  providers: [UsersDao],
  bootstrap: [AppComponent]
})
export class AppModule {
}
