import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {GeneralModule} from './general/general.module';
import {RouterModule} from '@angular/router';
import {APP_ROUTES} from './app.routing';
import {HttpClientModule} from "@angular/common/http";
import {ProductMgmtModule} from "./product-mgmt/product-mgmt.module";
import {ProductService} from "./product-mgmt/product.service";
import {CategoryService} from "./product-mgmt/category.service";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(APP_ROUTES, {useHash: true}),
    GeneralModule,
    ProductMgmtModule
  ],
  providers: [ProductService, CategoryService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
