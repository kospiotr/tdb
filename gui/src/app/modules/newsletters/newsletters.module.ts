//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {NewslettersComponent} from "./newsletters.component";
import {NewslettersListComponent} from "./newslettersList.component";
import {NewslettersRoutes} from "./newsletters.routes";
import {NewslettersResources} from "./newsletters.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    NewslettersRoutes
  ],
  exports: [],
  declarations: [
    NewslettersComponent,
    NewslettersListComponent,
  ],
  providers:[
    NewslettersResources
  ]
})
export class NewslettersModule {
}
