import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {GeneralModule} from './general/general.module';
import {RouterModule} from '@angular/router';
import {APP_ROUTES} from './app.routing';
import {BookService} from './book-mgmt/book.service';
import {HttpClientModule} from "@angular/common/http";
import {ProductMgmtModule} from "./product-mgmt/product-mgmt.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(APP_ROUTES),
    GeneralModule,
    ProductMgmtModule
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
