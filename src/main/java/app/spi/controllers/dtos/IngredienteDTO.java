package app.spi.controllers.dtos;

import app.spi.models.Ingrediente;
import app.spi.models.enums.UnidadeDeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;

public class IngredienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank
    @Size(max = 30)
    private String nome;
    @NotBlank
    @Size(max = 120)
    private String descricao;
    @NotNull
    private Double quantidade;
    @NotNull
    private UnidadeDeMedida unidadeDeMedida;
    @NotNull
    private BigDecimal custo;
    @NotBlank
    private String categoria;

    public IngredienteDTO() {
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

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public IngredienteDTO(Ingrediente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
        this.quantidade = obj.getQuantidade();
        this.unidadeDeMedida = obj.getUnidadeDeMedida();
        this.custo = obj.getCusto();
        this.categoria = obj.getCategoria();
    }
}
