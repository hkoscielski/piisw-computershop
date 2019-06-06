import { Component, OnInit } from '@angular/core';
import {Product, ProductService} from "../product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.scss']
})
export class ProductItemComponent implements OnInit {

  currentProduct: Product;
  tab = 0;

  constructor(private productService: ProductService, public route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params =>
      this.productService.findProductById(params['productId'])
        .subscribe(product => {
          this.currentProduct = product.body;
          this.currentProduct.imageUrl = `${product.url}/image`;
        }));
  }
}
