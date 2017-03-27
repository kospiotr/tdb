import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {UsersComponent} from "./users.component";
import {PaginationComponent} from "../../shared/pagination/pagination.component";
import {UsersRoutes} from "./users.routes";
import {UserComponent} from "./user.component";


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    UsersRoutes
  ],
  exports: [],
  declarations: [
    UsersComponent,
    UserComponent,
    PaginationComponent,
  ]
})
export class UsersModule {
}
