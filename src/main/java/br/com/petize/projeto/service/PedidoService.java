package br.com.petize.projeto.service;

import br.com.petize.projeto.model.PedidoModel;
import br.com.petize.projeto.model.StatusPedido;
import br.com.petize.projeto.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Criar um novo pedido
    public PedidoModel criarPedido(PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    // Listar todos os pedidos
    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido por ID
    public Optional<PedidoModel> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Atualizar um pedido
    public PedidoModel atualizarPedido(Long id, PedidoModel pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setData(pedidoAtualizado.getData());
            pedido.setQuantidade(pedidoAtualizado.getQuantidade());
            pedido.setPedido(pedidoAtualizado.getPedido());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    // Alterar o status de um pedido
    public PedidoModel alterarStatusPedido(Long id, StatusPedido status) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setStatus(status);
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    // Deletar um pedido
    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}

