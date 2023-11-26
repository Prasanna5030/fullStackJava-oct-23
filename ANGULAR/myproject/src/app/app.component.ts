import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { UserComponent } from './user/user.component';
import { ProductV2Component } from './product-v2/product-v2.component';
import { ProductlistComponent } from './productlist/productlist.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, ProductComponent, UserComponent, ProductV2Component, ProductlistComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title1 = 'MY GREAT GREAT ANGULAR CODE';

  username="user100";
  age=56;
}