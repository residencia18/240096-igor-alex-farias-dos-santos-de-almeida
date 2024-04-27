import { Routes } from '@angular/router';
import { ProdutosComponent } from './produtos/produtos.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';

export const routes: Routes = [
    { path: 'produtos', component: ProdutosComponent },
    { path: '', redirectTo: '/produtos', pathMatch: 'full' },
    { path: 'carrinho', component: CarrinhoComponent },
];
