# Projeto API REST para Cadastro de Produtos e Pedidos

Este projeto é uma API REST desenvolvida em Java com Spring Boot, destinada ao gerenciamento de produtos e pedidos. Ele permite a criação, leitura, atualização e exclusão (CRUD) de produtos e pedidos.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

- **Controladores (`controller`)**:
  - `PedidoController`: Gerencia as requisições relacionadas a pedidos.
  - `ProdutoController`: Gerencia as requisições relacionadas a produtos.

- **Modelos (`model`)**:
  - `PedidoModel`: Representa a entidade Pedido, contendo informações como data, quantidade e status.
  - `ProdutoModel`: Representa a entidade Produto, contendo informações como nome, preço, descrição e status.
  - `StatusPedido`: Enum que define os status possíveis de um pedido.

- **Repositórios (`repository`)**:
  - `PedidoRepository`: Interface para operações CRUD da entidade Pedido.
  - `ProdutoRepository`: Interface para operações CRUD da entidade Produto.

- **Serviços (`service`)**:
  - `PedidoService`: Contém a lógica de negócio para operações relacionadas a pedidos.
  - `ProdutoService`: Contém a lógica de negócio para operações relacionadas a produtos.

## Configuração do Banco de Dados

O projeto utiliza o MySQL como banco de dados. As configurações de conexão são feitas no arquivo `application.properties`.

## Execução do Projeto

O projeto é iniciado pela classe `ProjetoApirestCadastroDeProdutosEClientesApplication`.

## Como Executar o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/nicollaseu/seu-repositorio.git
   ```

# API de Produtos e Pedidos

Esta API permite a criação, listagem, busca, atualização e remoção de produtos e pedidos. Ela segue os métodos REST e pode ser testada utilizando ferramentas como Postman ou Insomnia.

Endpoints:

1. Criar Produto (POST /api/produtos) **URL:** `POST /api/produtos`

Exemplo de JSON de Requisição: 

```json
{
  "nome": "Produto Exemplo",
  "preco": 29.99,
  "descricao": "Uma descrição do produto",
  "status": "PENDENTE"
}
```

Resposta esperada (201 Created):

```json
{
  "id": 1,
  "nome": "Produto Exemplo",
  "preco": 29.99,
  "descricao": "Uma descrição do produto",
  "status": "PENDENTE",
  "pedido": null
}

```

2. Listar Produtos (GET /api/produtos)

**URL:** `GET /api/produtos`

Resposta esperada (200 OK):

```json
[
  {
    "id": 1,
    "nome": "Produto Exemplo",
    "preco": 29.99,
    "descricao": "Uma descrição do produto",
    "status": "PENDENTE",
    "pedido": null
  }
]

```

3. Buscar Produto por ID (GET /api/produtos/{id})

**URL:** `GET /api/produtos/1`

Resposta esperada (200 OK):

```json
{
  "id": 1,
  "nome": "Produto Exemplo",
  "preco": 29.99,
  "descricao": "Uma descrição do produto",
  "status": "PENDENTE",
  "pedido": null
}

```

4. Atualizar Produto (PUT /api/produtos/{id})

**URL:** `PUT /api/produtos/1`

Exemplo de JSON de Requisição:

```json
{
  "nome": "Produto Atualizado",
  "preco": 35.50,
  "descricao": "Descrição atualizada do produto",
  "status": "PROCESSANDO"
}

```

Resposta esperada (200 OK):

```json
{
  "id": 1,
  "nome": "Produto Atualizado",
  "preco": 35.50,
  "descricao": "Descrição atualizada do produto",
  "status": "PROCESSANDO",
  "pedido": null
}

```

5. Deletar Produto (DELETE /api/produtos/{id})

**URL:** `DELETE /api/produtos/1`

Resposta esperada (204 No Content).

# Pedidos

Endpoints:

6. Criar Pedido (POST /api/pedidos)
   URL: POST /api/pedidos

Exemplo de JSON de Requisição:

```json
{
  "data": "2024-10-16",
  "quantidade": 2,
  "status": "PENDENTE",
  "produtos": 
    {
      "nome": "Produto 1",
      "preco": 15.00,
      "descricao": "Descrição do produto 1",
      "status": "PENDENTE"
}
}
```

Resposta esperada (200 OK):

```json
{
	"id": 1,
	"data": "2024-10-16",
	"pedido": null,
	"quantidade": 2,
	"status": "PENDENTE"
}
```

7. Listar Pedidos (GET /api/pedidos)
   URL: GET /api/pedidos

Resposta esperada (200 OK):

```json
[
	{
		"id": 1,
		"data": "2024-10-16",
		"pedido": null,
		"quantidade": 2,
		"status": "PENDENTE"
	}
]
```

8. Buscar Pedido por ID (GET /api/pedidos/{id})
   URL: GET /api/pedidos/1

Resposta esperada (200 OK):

```json
{
	"id": 1,
	"data": "2024-10-16",
	"pedido": null,
	"quantidade": 2,
	"status": "PENDENTE"
}
```

9. Atualizar Pedido (PUT /api/pedidos/{id})
   URL: PUT /api/pedidos/1

Exemplo de JSON de Requisição:

```json
{
  "data": "2024-10-17",
  "quantidade": 3,
  "status": "PROCESSANDO",
  "produtos": [
    {
      "nome": "Produto Atualizado",
      "preco": 25.00,
      "descricao": "Descrição atualizada do produto",
      "status": "PROCESSANDO"
    }
  ]
}
```

Resposta esperada (200 OK):

```json
{
	"id": 1,
	"data": "2024-10-17",
	"pedido": null,
	"quantidade": 3,
	"status": "PENDENTE"
}
```

10. Alterar Status do Pedido (PUT /api/pedidos/{id})
    URL: PUT /api/pedidos/1/

Exemplo de JSON de Requisição:

```json
{
  "id": 1,
  "data": "2024-10-17",
  "quantidade": 3,
  "status": "ENVIADO",
  "produtos": [
    {
      "id": 1,
      "nome": "Produto Atualizado",
      "preco": 25.00,
      "descricao": "Descrição atualizada do produto",
      "status": "PROCESSANDO"
    }
  ]
}
```

Resposta esperada (200 OK):

```json
{
	"id": 1,
	"data": "2024-10-17",
	"pedido": null,
	"quantidade": 3,
	"status": "PENDENTE"
}
```

10. Deletar Pedido (DELETE /api/pedidos/{id})
    URL: DELETE /api/pedidos/1

Resposta esperada (204 No Content).