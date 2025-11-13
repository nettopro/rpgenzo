package github.nettopro.rpgenzo.entidade.tipo;

public enum TipoGrupo {
    BASICA("Básica"),
    CLASSE("Classe"),
    MAGIA("Magia"),
    RACA("Raça"),
    EQUIPAMENTO("Equipamento"),
    PERICIA("Perícia"),
    OUTRO("Outro");

    private final String descricao;

    TipoGrupo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
