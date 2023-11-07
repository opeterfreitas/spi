package app.spi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean isFuncionario;
    private BigDecimal salario;
    private BigDecimal valeTransporte;
    private BigDecimal valeRefeicao;
    private int diasTrabalhados;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, boolean isFuncionario, BigDecimal salario, BigDecimal valeTransporte, BigDecimal valeRefeicao, int diasTrabalhados) {
        this.id = id;
        this.nome = nome;
        this.isFuncionario = isFuncionario;
        this.salario = salario;
        this.valeTransporte = valeTransporte;
        this.valeRefeicao = valeRefeicao;
        this.diasTrabalhados = diasTrabalhados;
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

    public boolean isFuncionario() {
        return isFuncionario;
    }

    public void setFuncionario(boolean funcionario) {
        isFuncionario = funcionario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(BigDecimal valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public BigDecimal getValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(BigDecimal valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }
}
