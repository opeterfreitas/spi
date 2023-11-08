package app.spi.controllers.dtos;

import app.spi.models.Despesa;
import app.spi.models.enums.TipoDespesa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DespesaDTO {

    private Long id;
    @NotBlank
    @Size(max = 30)
    private String nome;
    @NotNull
    private TipoDespesa tipo;
    @NotNull
    private Double valor;

    public DespesaDTO() {
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

    public TipoDespesa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDespesa tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public DespesaDTO(Despesa obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.tipo = obj.getTipo();
        this.valor = obj.getValor();
    }
}
