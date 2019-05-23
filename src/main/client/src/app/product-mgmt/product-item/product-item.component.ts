import { Component, OnInit } from '@angular/core';
import {GraphicsCard, ProductService} from "../product.service";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.scss']
})
export class ProductItemComponent implements OnInit {

  currentGraphicsCard: GraphicsCard;
  currentImageUrl: string;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.findGraphicsCardById(3)
      .subscribe(graphicsCard => {
        this.currentGraphicsCard = graphicsCard.body;
        this.currentImageUrl = `${graphicsCard.url}\\image`;
      });
  }
}
