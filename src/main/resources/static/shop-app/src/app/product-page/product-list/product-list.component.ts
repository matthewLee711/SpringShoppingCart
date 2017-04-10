import { Component, OnInit } from '@angular/core';
import { ShopService } from '../../service/shop-service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(
    private shopService: ShopService
  ) { }

  ngOnInit() {
    //this.shopService.getItems().then(heroes => this.heroes = heroes)
  }
  loadProducts() {
    this.shopService.getItems1()
                    .subscribe(
                      
                    )
  }

}