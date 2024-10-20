package br.com.petize.projeto.controller;

import br.com.petize.projeto.model.PedidoModel;
import br.com.petize.projeto.model.StatusPedido;
import br.com.petize.projeto.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Criar um novo pedido
    @PostMapping
    public PedidoModel criarPedido(@RequestBody PedidoModel pedido) {
        return pedidoService.criarPedido(pedido);
    }

    // Listar todos os pedidos
    @GetMapping
    public List<PedidoModel> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    // Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPorId(@PathVariable Long id) {
        Optional<PedidoModel> pedido = pedidoService.buscarPorId(id);
        return pedido.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um pedido
    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizarPedido(@PathVariable Long id, @RequestBody PedidoModel pedido) {
        return ResponseEntity.ok(pedidoService.atualizarPedido(id, pedido));
    }

    // Alterar o status de um pedido
    @PutMapping("/{id}/status")
    public ResponseEntity<PedidoModel> alterarStatus(@PathVariable Long id, @RequestParam StatusPedido status) {
        return ResponseEntity.ok(pedidoService.alterarStatusPedido(id, status));
    }

    // Deletar um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}