package br.com.petize.projeto.service;

import br.com.petize.projeto.model.ProdutoModel;
import br.com.petize.projeto.model.StatusPedido;
import br.com.petize.projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Criar um novo produto
    public ProdutoModel criarProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    // Listar todos os produtos
    public List<ProdutoModel> listarProdutos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Listar produtos por pedido
    public List<ProdutoModel> listarProdutosPorPedido(Long pedidoId) {
        return produtoRepository.findByPedidoId(pedidoId);
    }

    // Listar produtos por status de pedido
    public List<ProdutoModel> listarProdutosPorStatus(StatusPedido status) {
        return produtoRepository.findByStatus(status);
    }

    // Atualizar um produto
    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Deletar um produto
    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
