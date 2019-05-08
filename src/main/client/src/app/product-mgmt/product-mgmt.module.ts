import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductItemComponent } from './product-item/product-item.component';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { ProductMainComponent } from './product-main/product-main.component';

@NgModule({
  declarations: [ProductItemComponent, ProductCategoryComponent, ProductMainComponent],
  imports: [
    CommonModule
  ]
})
export class ProductMgmtModule { }
