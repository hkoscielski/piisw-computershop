import { Component, OnInit } from '@angular/core';
import {Category, CategoryService} from "../category.service";
import {Product, ProductService} from "../product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-main',
  templateUrl: './product-main.component.html',
  styleUrls: ['./product-main.component.scss']
})
export class ProductMainComponent implements OnInit {

  hotProductList: Product[] = [];

  constructor(public categoryService: CategoryService, public productService: ProductService, public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.categoryService.findAll().subscribe(categories =>
      categories.content.forEach(cat =>
        this.productService.findProductsListInCategory(cat.id).subscribe(productList => {
          if (productList.body.content[0]) this.hotProductList[this.hotProductList.length] = productList.body.content[0];
        })
      )
    )
  }

}
