package app.spi.models;

import app.spi.controllers.dtos.IngredienteDTO;
import app.spi.models.enums.UnidadeDeMedida;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double quantidade;
	@Enumerated(EnumType.STRING)
	private UnidadeDeMedida unidadeDeMedida;
	private BigDecimal custo;
	private String categoria;
	@JsonIgnore
	@ManyToMany(mappedBy = "ingredientes")
	private List<Receita> receitas;

	public Ingrediente() {
	}

	public Ingrediente(Long id, String nome, String descricao, Double quantidade, UnidadeDeMedida unidadeDeMedida, BigDecimal custo, String categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.unidadeDeMedida = unidadeDeMedida;
		this.custo = custo;
		this.categoria = categoria;
	}

	public Ingrediente(IngredienteDTO objDTO) {
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
		this.descricao = objDTO.getDescricao();
		this.quantidade = objDTO.getQuantidade();
		this.unidadeDeMedida = objDTO.getUnidadeDeMedida();
		this.custo = objDTO.getCusto();
		this.categoria = objDTO.getCategoria();
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

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}
}