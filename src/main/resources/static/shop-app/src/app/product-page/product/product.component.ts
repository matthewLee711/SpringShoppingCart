import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../../model/product';
import { ShopService } from '../../service/shop-service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [ShopService]
})
export class ProductComponent implements OnInit {

  @Input('app-product') data: Product;
  constructor(
    private shopService: ShopService
  ) { }

  ngOnInit() {
  }

  purchaseItem(name: string) {
    this.shopService.purchaseItem(name)
                    .subscribe(data => {
                      console.log(data);
                    }, error => {
                      console.log(error);
                    });
  }
}
