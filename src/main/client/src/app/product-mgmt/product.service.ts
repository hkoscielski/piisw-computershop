import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  findGraphicsCardById(id: number): Observable<HttpResponse<GraphicsCard>> {
    return this.httpClient.get<GraphicsCard>(`/api/graphics-cards/${id}`, { observe: 'response' });
  }
}

export class GraphicsCard {
  id?: number;
  chipsetManufacturer: string;
  chipset: string;
  memorySize: string;
  memoryType: string;
  coreSpeed: string;
  memorySpeed: string;
  connectorType: string;

  constructor(chipsetManufacturer: string, chipset: string,
              memorySize: string, memoryType: string, coreSpeed: string,
              memorySpeed: string, connectorType: string, id?: number) {

    this.id = id;
    this.chipsetManufacturer = chipsetManufacturer;
    this.chipset = chipset;
    this.memorySize = memorySize;
    this.memoryType = memoryType;
    this.coreSpeed = coreSpeed;
    this.memorySpeed = memorySpeed;
    this.connectorType = connectorType;
  }
}
