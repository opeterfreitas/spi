package app.spi.controllers.dtos;

import app.spi.models.Embalagem;
import app.spi.models.Ingrediente;
import app.spi.models.enums.UnidadeDeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmbalagemDTO {

    private Long id;
    @NotBlank
    @Size(max = 30)
    private String nome;
    @NotBlank
    @Size(max = 120)
    private String descricao;
    @NotNull
    private double quantidade;
    @NotNull
    private UnidadeDeMedida unidadeDeMedida;
    @NotNull
    private Double custo;

    public EmbalagemDTO() {
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

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public EmbalagemDTO(Embalagem obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
        this.quantidade = obj.getQuantidade();
        this.unidadeDeMedida = obj.getUnidadeDeMedida();
        this.custo = obj.getCusto();
    }

}
