import {Routes} from '@angular/router';
import {ProductMainComponent} from "./product-mgmt/product-main/product-main.component";
import {ProductCategoryComponent} from "./product-mgmt/product-category/product-category.component";
import {ProductItemComponent} from "./product-mgmt/product-item/product-item.component";

export const APP_ROUTES: Routes = [
  {
    path: 'app',
    children: [
      {
        path: 'overview',
        component: ProductMainComponent
      },
      {
        path: 'categories/:categoryId',
        component: ProductCategoryComponent
      },
      {
        path: 'products/:productId',
        component: ProductItemComponent
      },
    ]
  },
  {
    path: '',
    redirectTo: '/app/overview',
    pathMatch: 'full'
  }
];
