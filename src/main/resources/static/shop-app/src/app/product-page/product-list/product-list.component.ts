import { Component, OnInit } from '@angular/core';
import { ShopService } from '../../service/shop-service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  providers: [ShopService]
})
export class ProductListComponent implements OnInit {

  constructor(
    private shopService: ShopService
  ) { }

  ngOnInit() {
    //this.shopService.getItems().then(heroes => this.heroes = heroes)
    this.loadProducts();
  }
  loadProducts() {
    this.shopService.getItems1()
                    .subscribe(data => {
                      console.log(data);
                    }, error => {
                      console.log(error);
                    });
  }

}
