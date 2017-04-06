//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.module.ts.e.vm
//
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AssetsComponent} from "./assets.component";
import {AssetsListComponent} from "./assetsList.component";
import {AssetsRoutes} from "./assets.routes";
import {AssetsResources} from "./assets.resources";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    AssetsRoutes
  ],
  exports: [],
  declarations: [
    AssetsComponent,
    AssetsListComponent,
  ],
  providers:[
    AssetsResources
  ]
})
export class AssetsModule {
}
