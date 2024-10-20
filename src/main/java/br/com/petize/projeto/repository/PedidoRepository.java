package br.com.petize.projeto.repository;

import br.com.petize.projeto.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
    // Repositório padrão para operações CRUD de Pedido
}