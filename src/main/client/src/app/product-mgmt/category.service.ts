import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Page<Category[]>> {
    return this.httpClient.get<Page<Category[]>>(`${environment.apiBaseUrl}/api/products/categories`);
  }

  findCategoryById(id: number): Observable<Category> {
    return this.httpClient.get<Category>(`${environment.apiBaseUrl}/api/products/categories/${id}`)
  }
}

class Page<T> {
  content: T;
  page: number;
  size: number;
}

export class Category {
  id?: number;
  name: string;
}
