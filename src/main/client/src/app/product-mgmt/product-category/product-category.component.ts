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
    console.log("Weszlo")
  }

  ngOnInit() {
    this.route.params.subscribe(params => this.currentCategoryId = params['categoryId'])
    this.findCategory()
    this.findProductList()
  }

  ngOnChanges() {
    this.route.params.subscribe(params => this.currentCategoryId = params['categoryId'])
    this.findCategory()
    this.findProductList
  }

  findCategory() {
      this.categoryService.findCategoryById(this.currentCategoryId).subscribe(category =>  this.currentCategory = category)
  }

  findProductList() {
      this.productService.findProductsListInCategory(this.currentCategoryId).subscribe(productList =>  this.currentProductList = productList.body.content)
  }

}
