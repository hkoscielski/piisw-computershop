import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductItemComponent} from './product-item/product-item.component';
import {ProductCategoryComponent} from './product-category/product-category.component';
import {ProductMainComponent} from './product-main/product-main.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {GeneralModule} from "../general/general.module";
import {CategoryNavComponent} from "../general/category-nav/category-nav.component";
import {NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [ProductItemComponent, ProductCategoryComponent, ProductMainComponent, CategoryNavComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    GeneralModule,
    NgbPaginationModule
  ]
})
export class ProductMgmtModule {
}
