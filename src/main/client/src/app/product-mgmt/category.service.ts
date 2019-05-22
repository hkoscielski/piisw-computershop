import { Injectable } from '@angular/core';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  categories: Category[] = []

  constructor() {
    this.categories = [
      {id: 1, name: 'Karty graficzne'},
      {id: 2, name: 'Procesory'},
      {id: 3, name: 'Monitory'},
      {id: 4, name: 'Akcesoria'}
    ]
  }

  findAll(): Category[] {
    return this.categories;
  }
}

export class Category {
  id?: number;
  name: string;
}
