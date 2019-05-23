import { Component, OnInit } from '@angular/core';
import {Category, CategoryService} from "../../product-mgmt/category.service";

@Component({
  selector: 'app-category-nav',
  templateUrl: './category-nav.component.html',
  styleUrls: ['./category-nav.component.scss']
})
export class CategoryNavComponent implements OnInit {

  currentCategories: Category[];

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.currentCategories = this.categoryService.findAll();
  }

}
