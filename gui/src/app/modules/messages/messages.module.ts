//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {MessagesComponent} from "./messages.component";
import {MessagesListComponent} from "./messagesList.component";
import {MessagesRoutes} from "./messages.routes";
import {MessagesResources} from "./messages.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    MessagesRoutes
  ],
  exports: [],
  declarations: [
    MessagesComponent,
    MessagesListComponent,
  ],
  providers:[
    MessagesResources
  ]
})
export class MessagesModule {
}
