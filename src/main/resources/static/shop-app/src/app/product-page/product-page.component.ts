import { Component, OnInit } from '@angular/core';

import { ProductComponent } from './product/product.component';
import { ProductListComponent } from './product-list/product-list.component'

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
