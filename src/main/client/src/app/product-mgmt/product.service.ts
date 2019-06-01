import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
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
}

export class Product {
  id?: number;
  name: string;
  price: number;
  categoryName: string;
  mainAttributes: ProductAttr[];
  additionalAttributes: ProductAttr[];
}

export class ProductAttr {
  name: string;
  value: string;
}
