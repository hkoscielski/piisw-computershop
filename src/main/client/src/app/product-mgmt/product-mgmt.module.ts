import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductItemComponent} from './product-item/product-item.component';
import {ProductCategoryComponent} from './product-category/product-category.component';
import {ProductMainComponent} from './product-main/product-main.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [ProductItemComponent, ProductCategoryComponent, ProductMainComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    HttpClientModule
  ]
})
export class ProductMgmtModule {
}
