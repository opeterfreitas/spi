package app.spi.models.enums;

public enum UnidadeDeMedida {
    GRAMA("g"), QUILOGRAMA("kg"), MILIGRAMA("mg"), LITRO("L"), MILILITRO("mL"), UNIDADE("un"),
    COLHER_DE_SOPA("colher de sopa"), COLHER_DE_CHA("colher de chá"), XICARA("xícara");

    private final String descricao;

    UnidadeDeMedida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
