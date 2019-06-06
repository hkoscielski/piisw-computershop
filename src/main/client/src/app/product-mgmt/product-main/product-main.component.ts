import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../category.service";
import {Product, ProductService} from "../product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-main',
  templateUrl: './product-main.component.html',
  styleUrls: ['./product-main.component.scss']
})
export class ProductMainComponent implements OnInit {

  hotProductList: Product[] = [];

  constructor(public categoryService: CategoryService, public productService: ProductService, public route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.categoryService.findAll().subscribe(categories =>
      categories.content.forEach(cat =>
        this.productService.findProductsListInCategory(cat.id, 0, 1).subscribe(productList => {
          if (productList.body.content[0]) {
            const tempProduct = productList.body.content[0];
            tempProduct.imageUrl = `${productList.url.replace(/\?(.*)/g, '')}/${tempProduct.id}/image`;
            this.hotProductList[this.hotProductList.length] = tempProduct;
          }
        })
      )
    )
  }

}
