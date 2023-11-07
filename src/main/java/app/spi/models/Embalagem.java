package app.spi.models;

import app.spi.controllers.dtos.EmbalagemDTO;
import app.spi.models.enums.UnidadeDeMedida;
import jakarta.persistence.*;

@Entity
public class Embalagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double quantidade;
    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unidadeDeMedida;
    private double custo;

    public Embalagem() {
    }

    public Embalagem(Long id, String nome, String descricao, double quantidade, UnidadeDeMedida unidadeDeMedida, double custo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.unidadeDeMedida = unidadeDeMedida;
        this.custo = custo;
    }
    public Embalagem(EmbalagemDTO objDTO) {
        this.id = objDTO.getId();
        this.nome = objDTO.getNome();
        this.descricao = objDTO.getDescricao();
        this.quantidade = objDTO.getQuantidade();
        this.unidadeDeMedida = objDTO.getUnidadeDeMedida();
        this.custo = objDTO.getCusto();
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
