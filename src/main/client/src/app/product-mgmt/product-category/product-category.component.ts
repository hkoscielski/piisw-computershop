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
  page: number;
  size: number;
  totalElements: number;

  constructor(public categoryService: CategoryService, public productService: ProductService, public route: ActivatedRoute) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      console.log('init');
      this.page = 1;
      this.size = 8;
      this.totalElements = 20;
      this.currentCategory = null;
      this.currentProductList = null;
      this.findCategory(params['categoryId']);
      this.findProductList(params['categoryId']);
    })
  }

  findCategory(categoryId: number) {
      this.categoryService.findCategoryById(categoryId).subscribe(category => this.currentCategory = category)
  }

  findProductList(categoryId: number) {
    this.productService.findProductsListInCategory(categoryId, this.page - 1, this.size).subscribe(productList => {
        this.currentProductList = productList.body.content.map(product => {
          product.imageUrl = `${productList.url.replace(/\?(.*)/g, '')}/${product.id}/image`;
          return product;
        });
        this.totalElements = productList.body.totalElements;
      });
    console.log(this.page)
  }

  onPageChange(page: number) {
    this.page = page;
    this.findProductList(this.currentCategory.id);
  }
}
