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
  tab = 0;
  parameters: string[];

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.findGraphicsCardById(3)
      .subscribe(graphicsCard => {
        this.currentGraphicsCard = graphicsCard.body;
        this.currentImageUrl = `${graphicsCard.url}\\image`;
        this.findAllParameters();
      });
  }

  findAllParameters() {
    this.parameters[0] = "Chipset: " + this.currentGraphicsCard.chipset;
    this.parameters[1] = "Chipset Manufacturer: " + this.currentGraphicsCard.chipsetManufacturer;
    this.parameters[2] = "connectorType: " + this.currentGraphicsCard.connectorType;
    this.parameters[3] = "coreSpeed: " + this.currentGraphicsCard.coreSpeed;
    this.parameters[4] = "memorySize: " + this.currentGraphicsCard.memorySize;
    this.parameters[5] = "memorySpeed: " + this.currentGraphicsCard.memorySpeed;
    this.parameters[6] = "memoryType: " + this.currentGraphicsCard.memoryType;

  }
}
