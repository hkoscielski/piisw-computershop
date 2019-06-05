import { Component, OnInit } from '@angular/core';
import {Category, CategoryService} from "../category.service";

@Component({
  selector: 'app-product-main',
  templateUrl: './product-main.component.html',
  styleUrls: ['./product-main.component.scss']
})
export class ProductMainComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
  }

}
