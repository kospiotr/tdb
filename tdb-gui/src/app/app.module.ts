import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {LayoutComponent} from "./shared/layout/layout.component";
import {AppRoutes} from "./app.routes";
import {DashboardComponent} from "./modules/dashboard/dashboard.component";
import {UsersComponent} from "./modules/users/users.component";
import {UsersDao} from "./modules/users/user.dao";
import { PaginationComponent } from './shared/pagination/pagination.component';
import {UsersModule} from "./modules/users/users.module";

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    UsersModule,
    HttpModule,
    AppRoutes
  ],
  providers: [UsersDao],
  bootstrap: [AppComponent]
})
export class AppModule {
}
