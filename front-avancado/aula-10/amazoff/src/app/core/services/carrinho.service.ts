import { Injectable } from "@angular/core";
import { signal, computed } from "@angular/core";

export interface Item {
  id: number;
  name: string;
  price: number;
  quantity: number;
  imgURL: string;
}
@Injectable({
  providedIn: "root",
})
export class CarrinhoService {
  carrinhoSignal: any;
  itensDoCarrinho: Item[];
  subtotal: any;
  quantidadeNoCarrinho: any;

  constructor() {
    this.itensDoCarrinho = [];
    this.carrinhoSignal = signal(this.itensDoCarrinho);

    // Calcula o subtotal do carrinho
    this.subtotal = computed(() => {
      let total = 0;
      this.carrinhoSignal().forEach((item: any) => {
        total += item.price * item.quantity;
      });
      return total;
    });

    // Calcula a quantidade de itens no carrinho
    this.quantidadeNoCarrinho = computed(() => {
      return this.carrinhoSignal().reduce(
        (total: number, item: Item) => total + item.quantity,
        0
      );
    });
  }

  removeItem(index: number) {
    const updatedItens = this.carrinhoSignal().filter(
      (_: any, i: any) => i !== index
    );
    this.carrinhoSignal.set(updatedItens);
  }

  /**
   * Adiciona um produto ao carrinho.
   * @param produto O produto a ser adicionado.
   * @param atualizarQuantidade Indica se a quantidade do produto deve ser atualizada.
   */
  adicionarAoCarrinho(produto: Item, atualizarQuantidade = false) {
    var produtoNoCarrinho = this.carrinhoSignal().find(
      (item: any) => item.id === produto.id
    );

    if (produtoNoCarrinho) {
      const updatedItens = this.carrinhoSignal().map((item: Item) => {
        if (item.id === produto.id) {
          return {
            ...item,
            quantity:
              atualizarQuantidade ? produto.quantity : item.quantity + 1,
          };
        }
        return item;
      });
      this.carrinhoSignal.set(updatedItens);
    } else {
      this.carrinhoSignal.set([...this.carrinhoSignal(), produto]);
    }
  }
}
