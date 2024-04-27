import { Component, ElementRef, ViewChild } from '@angular/core';
import { CarrinhoService, Item } from '../core/services/carrinho.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: "app-produtos",
  standalone: true,
  imports: [CommonModule],
  templateUrl: "./produtos.component.html",
  styleUrl: "./produtos.component.css",
})
export class ProdutosComponent {
  @ViewChild("confirmacao", { static: false }) confirmacaoElement:
    | ElementRef
    | undefined;
  produtoAdicionado: string = "";
  produtos: Item[];

  constructor(private carrinhoService: CarrinhoService) {
    this.produtos = this.gerarProdutos();
  }

  adicionarAoCarrinho(produto: Item) {
    this.carrinhoService.adicionarAoCarrinho(produto);
    this.mostrarConfirmacao(produto.name);
  }

  mostrarConfirmacao(nomeProduto: string) {
    if (this.confirmacaoElement) {
      this.produtoAdicionado = nomeProduto;
      const element = this.confirmacaoElement.nativeElement;
      element.classList.remove("d-none");
      setTimeout(() => {
        element.classList.add("d-none");
      }, 2000);
    }
  }

  gerarProdutos() : Item[] {
    return [
      {
        id: 1,
        name: "Produto 1",
        price: 10.99,
        quantity: 1,
        imgURL: "assets/default-product-image.png",
          
      },
      {
        id: 2,
        name: "Produto 2",
        price: 20.99,
        quantity: 1,
        imgURL:
          "assets/default-product-image.png",
      },
      {
        id: 3,
        name: "Produto 3",
        price: 30.99,
        quantity: 1,
        imgURL:
          "assets/default-product-image.png",
      },
      {
        id: 4,
        name: "Produto 4",
        price: 40.99,
        quantity: 1,
        imgURL:
          "assets/default-product-image.png",
      },
      {
        id: 5,
        name: "Produto 5",
        price: 50.99,
        quantity: 1,
        imgURL:
          "assets/default-product-image.png",
      },
    ];
  }
}
