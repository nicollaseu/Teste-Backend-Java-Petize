package br.com.petize.projeto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto", nullable = true, length = 255)
    private String nome;

    @Column(name = "preco", nullable = true, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @JsonIgnoreProperties("pedido")
    private PedidoModel pedido;  // Nome alterado de 'produto' para 'pedido' para refletir corretamente o relacionamento

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
