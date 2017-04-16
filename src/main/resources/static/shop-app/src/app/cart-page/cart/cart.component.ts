import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../../model/product';
//import { CartService } from '../../service/cart-service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  @Input('app-cart') data: Product;
  constructor() { }

  ngOnInit() {
  }

}
