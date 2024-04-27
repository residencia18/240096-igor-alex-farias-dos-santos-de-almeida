import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { ProdutosComponent } from './produtos/produtos.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { NavbarComponent } from './navbar/navbar.component';

@Component({
  selector: "app-root",
  standalone: true,
  imports: [RouterOutlet, RouterModule, ProdutosComponent, CarrinhoComponent, NavbarComponent],
  template: `
    <app-navbar></app-navbar>
    <router-outlet></router-outlet>
  `,
  styles: [
    `
    `,
  ],
})
export class AppComponent {
  title = "amazoff";
}
