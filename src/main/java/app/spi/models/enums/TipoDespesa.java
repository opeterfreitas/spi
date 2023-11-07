package app.spi.models.enums;

public enum TipoDespesa {
    ADMINISTRATIVA("Administrativa"), VENDAS("Vendas");

    private final String descricao;

    TipoDespesa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
