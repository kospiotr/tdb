//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {ResearchComponent} from "./research.component";
import {ResearchListComponent} from "./researchList.component";
import {ResearchRoutes} from "./research.routes";
import {ResearchResources} from "./research.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    ResearchRoutes
  ],
  exports: [],
  declarations: [
    ResearchComponent,
    ResearchListComponent,
  ],
  providers:[
    ResearchResources
  ]
})
export class ResearchModule {
}
