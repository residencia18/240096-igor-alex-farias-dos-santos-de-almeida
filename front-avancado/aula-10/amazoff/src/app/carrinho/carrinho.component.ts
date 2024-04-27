import { Component } from '@angular/core';
import { CarrinhoService, Item } from '../core/services/carrinho.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: "app-carrinho",
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: "./carrinho.component.html",
  styleUrls: ["./carrinho.component.css"],
})
export class CarrinhoComponent {
  constructor(public carrinhoService: CarrinhoService) {
  }

  removerItem(index: number) {
    this.carrinhoService.removeItem(index);
  }

  adicionarItemQtyCarrinho(item : Item) {
    this.carrinhoService.adicionarAoCarrinho(item, true);
    
  }
}
