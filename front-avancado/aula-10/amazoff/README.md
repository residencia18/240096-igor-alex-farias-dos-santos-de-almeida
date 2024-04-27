# Amazoff - Plataforma de E-commerce

Amazoff é uma aplicação de e-commerce desenvolvida em [Angular CLI](https://github.com/angular/angular-cli) 17.1.2 para gerenciar produtos e carrinho de compras.

## Funcionalidades Principais

### Produtos Disponíveis

- Exibe uma lista de produtos disponíveis para compra.
- Cada produto possui nome, preço, imagem e opção para adicionar ao carrinho.

### Carrinho de Compras

- Permite visualizar os itens no carrinho de compras.
- Possibilidade de remover itens do carrinho e atualizar a quantidade.
- Mostra o subtotal dos produtos no carrinho.

### Barra de Navegação

- Navegação entre as páginas de Produtos e Carrinho de Compras.
- Exibição do número de itens no carrinho na barra de navegação.

## Desenvolvimento

O projeto está estruturado com os seguintes componentes principais:

- **Produtos Component**: Exibe a lista de produtos disponíveis e permite adicionar produtos ao carrinho.
- **Carrinho Component**: Mostra os itens no carrinho de compras e permite gerenciar o carrinho.
- **Navbar Component**: Barra de navegação para facilitar a navegação entre as páginas.

### Utilização de `signal` e `computed` 

O método `signal` e `computed` foram utilizados no serviço `CarrinhoService` para obter o resultado dinâmico do carrinho de compras. O `signal` é utilizado para criar um sinal que é atualizado sempre que há mudanças nos itens do carrinho, enquanto o `computed` é utilizado para calcular o subtotal do carrinho e a quantidade total de itens.

### Bootstrap
O projeto utiliza o framework Bootstrap para estilização dos componentes e layout responsivo.

## Como Executar

1. Clone o repositório.
2. Instale as dependências com `npm install`.
3. Execute a aplicação com `ng serve`.
4. Acesse a aplicação em `http://localhost:4200/`.
