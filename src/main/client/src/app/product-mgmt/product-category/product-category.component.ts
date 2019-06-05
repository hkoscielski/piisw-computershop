import { Component, OnInit } from '@angular/core';
import {Category, CategoryService} from "../category.service";
import {Product, ProductService} from "../product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.scss']
})
export class ProductCategoryComponent implements OnInit {

  currentCategory: Category;
  currentProductList: Product[];
  currentCategoryId: number;

  constructor(public categoryService: CategoryService, public productService: ProductService, public route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.findCategory(params['categoryId']);
      this.findProductList(params['categoryId']);
    })
  }

  findCategory(categoryId: number) {
      this.categoryService.findCategoryById(categoryId).subscribe(category => this.currentCategory = category)
      console.log("weszlo")
  }

  findProductList(categoryId: number) {
      this.productService.findProductsListInCategory(categoryId).subscribe(productList => this.currentProductList = productList.body.content)
  }

}
