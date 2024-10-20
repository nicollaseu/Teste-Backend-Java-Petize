package br.com.petize.projeto.repository;

import br.com.petize.projeto.model.ProdutoModel;
import br.com.petize.projeto.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    // Listar todos os produtos de um pedido específico
    List<ProdutoModel> findByPedidoId(Long pedidoId);

    // Verificar se um produto está associado a um pedido com determinado status
    List<ProdutoModel> findByStatus(StatusPedido status);
}
