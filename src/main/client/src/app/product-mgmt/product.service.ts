import {Injectable} from '@angular/core';
import {HttpClient, HttpParams, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  findProductById(id: number): Observable<HttpResponse<Product>> {
    return this.httpClient.get<Product>(`/api/products/${id}`, { observe: 'response' });
  }

  findProductsListInCategory(id: number, page: number, size: number): Observable<HttpResponse<Page<Product[]>>> {
    const params = new HttpParams()
      .set('categoryId', id.toString())
      .set('page', page.toString())
      .set('size', size.toString());
    return this.httpClient.get<Page<Product[]>>(`/api/products`, {observe: 'response', params} )
  }
}

class Page<T> {
  content: T;
  number: number;
  size: number;
  totalElements: number;
}

export class Product {
  id?: number;
  name: string;
  price: number;
  categoryName: string;
  imageUrl: string;
  mainAttributes: ProductAttr[];
  additionalAttributes: ProductAttr[];
  description: string;
}

export class ProductAttr {
  name: string;
  value: string;
}
