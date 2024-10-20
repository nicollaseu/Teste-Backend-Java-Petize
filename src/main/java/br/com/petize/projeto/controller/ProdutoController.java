package br.com.petize.projeto.controller;

import br.com.petize.projeto.model.ProdutoModel;
import br.com.petize.projeto.model.StatusPedido;
import br.com.petize.projeto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Criar um novo produto
    @PostMapping
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.criarProduto(produto);
    }

    // Listar todos os produtos
    @GetMapping
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listarProdutos();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id) {
        Optional<ProdutoModel> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar produtos por pedido
    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<ProdutoModel>> listarProdutosPorPedido(@PathVariable Long pedidoId) {
        List<ProdutoModel> produtos = produtoService.listarProdutosPorPedido(pedidoId);
        return ResponseEntity.ok(produtos);
    }

    // Listar produtos por status de pedido
    @GetMapping("/status")
    public ResponseEntity<List<ProdutoModel>> listarProdutosPorStatus(@RequestParam StatusPedido status) {
        List<ProdutoModel> produtos = produtoService.listarProdutosPorStatus(status);
        return ResponseEntity.ok(produtos);
    }

    // Atualizar um produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produto) {
        return ResponseEntity.ok(produtoService.atualizarProduto(id, produto));
    }

    // Deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
