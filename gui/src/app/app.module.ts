import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {LayoutComponent} from "./shared/layout/layout.component";
import {AppRoutes} from "./app.routes";
import {MenuComponent} from "./shared/menu/menu.component";
import * as customModules from "./modules/customModules";
import * as generatedModules from "./modules/generatedModules";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: ([
    BrowserModule,
    FormsModule,
    HttpModule, AppRoutes
  ] as any[])
    .concat(customModules.modules)
    .concat(generatedModules.modules),
  // ] as any[]).concat(customModules.modules, generatedModules.modules) as any[],
  bootstrap: [AppComponent]
})
export class AppModule {
}
