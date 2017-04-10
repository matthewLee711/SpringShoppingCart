import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { ProductListComponent } from './product-page/product-list/product-list.component';
import { ProductComponent } from './product-page/product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductPageComponent,
    ProductListComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
