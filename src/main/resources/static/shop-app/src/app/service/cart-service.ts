import { Injectable } from '@angular/core';
//import { Router, ActivatedRoute } from '@angular/router';
import { Http, Headers, Response, RequestOptions, URLSearchParams } from '@angular/http';

import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {BehaviorSubject} from "rxjs/Rx";

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

export class Product {
  constructor(
    public name: string,
    public description: string,
    public price: number,
    public stock: number
  ) {

  }
}

@Injectable()
export class CartService {

  private postUrl = 'http://localhost:8080/cart/getCart';

  constructor(
    //private _router: Router,
    //private route: ActivatedRoute,
    private http: Http
  ) {

  }

  getCart(username: string) {
    let data = {'user': username};
    let body = JSON.stringify(data);
    let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers }); // Create a request option
    return this.http.post(this.postUrl, name, options) // ...using post request
                     .map((res:Response) => res.json())
  }


}
