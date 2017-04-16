import { Component, OnInit } from '@angular/core';
import { CartService } from '../../service/cart-service';
import { CartComponent } from '../cart/cart.component';
import { Product } from '../../model/product';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css'],
  providers:[CartService]
})
export class CartListComponent implements OnInit {
  public cartArr: Product[];
  public product: Product;

  constructor(
    private cartService: CartService
  ) {
    this.cartArr = [];
  }

  ngOnInit() {
  }

  loadCart() {
    this.cartService.getCart('user')
                    .subscribe(data => {
                      for(var i = 0; i < data.length; i++) {
                        this.product = new Product(data[i].name, data[i].description, data[i].price, data[i].stock);
                        this.cartArr.unshift(this.product)
                      }
                    }, error => {
                      console.log(error);
                    });
  }

}
