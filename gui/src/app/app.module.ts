import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {AppRoutes} from "./app.routes";
import * as customModules from "./modules/customModules";
import * as generatedModules from "./gen-modules/generatedModules";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: (([
    BrowserModule,
    FormsModule,
    HttpModule, AppRoutes
  ] as any[])
    .concat(customModules.modules)
    .concat(generatedModules.modules)) as any[],
  bootstrap: [AppComponent]
})
export class AppModule {
}
