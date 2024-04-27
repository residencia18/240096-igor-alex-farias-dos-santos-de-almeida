import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { CarrinhoService } from '../core/services/carrinho.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: "app-navbar",
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.css"],
})
export class NavbarComponent {
  title = "amazoff";
  quantidadeComputed : any;

  constructor(private _carrinho : CarrinhoService) {
    this.quantidadeComputed = _carrinho.quantidadeNoCarrinho;
  }
}
