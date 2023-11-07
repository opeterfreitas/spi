package app.spi.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @ManyToMany
    @JoinTable(name = "receita_ingrediente",
            joinColumns = @JoinColumn(name = "receita_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredientes;

    public Receita() {
    }

    public Receita(Long id, String nome, String descricao, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ingredientes = ingredientes;
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

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
