import { Component, OnInit } from '@angular/core';
import {Product, ProductService} from "../product.service";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.scss']
})
export class ProductItemComponent implements OnInit {

  currentProduct: Product;
  currentImageUrl: string;
  tab = 0;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.findProductById(2)
      .subscribe(product => {
        this.currentProduct = product.body;
        this.currentImageUrl = `${product.url}\\image`;
      });
  }
}
