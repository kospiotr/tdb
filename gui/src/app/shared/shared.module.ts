//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {LayoutComponent} from "./layout/layout.component";
import {MenuComponent} from "./menu/menu.component";
import {PaginationComponent} from "./pagination/pagination.component";
import {RouterModule} from "@angular/router";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    LayoutComponent,
    PaginationComponent
  ],
  declarations: [
    LayoutComponent,
    MenuComponent,
    PaginationComponent,
  ]
})
export class SharedModule {
}
