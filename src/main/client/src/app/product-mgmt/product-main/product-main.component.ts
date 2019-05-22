import { Component, OnInit } from '@angular/core';
import {Category, CategoryService} from "../category.service";
import {RouterModule} from "@angular/router";

@Component({
  selector: 'app-product-main',
  templateUrl: './product-main.component.html',
  styleUrls: ['./product-main.component.scss']
})
export class ProductMainComponent implements OnInit {

  currentCategories: Category[];

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.currentCategories = this.categoryService.findAll();
  }

}
