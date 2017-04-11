import { Injectable } from '@angular/core';
//import { Router, ActivatedRoute } from '@angular/router';
import { Http, Headers, Response, RequestOptions } from '@angular/http';

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
export class ShopService {

  private products: Product[];
  private getUrl = 'https://private-16d7d-closebites.apiary-mock.com/todos';
  private getUrl2 = 'https://private-16d7d-closebites.apiary-mock.com/product';
  constructor(
    //private _router: Router,
    //private route: ActivatedRoute,
    private http: Http
  ) {

  }

  getItems(): Promise<Product[]> {

    return Promise.resolve(this.products);
  }
  //https://scotch.io/tutorials/angular-2-http-requests-with-observables
  getItems1(): Observable<Product[]> {
    return this.http.get(this.getUrl2)
                    .map((res:Response) => res.json())
                    //.catch((error:any) => Observable.throw(error.json().error || 'Server error'))
  }

  purchaseItem(body: Object): Observable<Product[]> {
    let bodyString = JSON.stringify(body); // Stringify payload
    let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers }); // Create a request option

    return this.http.post(this.getUrl, body, options) // ...using post request
                     .map((res:Response) => res.json()) // ...and calling .json() on the response to return data
                     .catch((error:any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }

}
