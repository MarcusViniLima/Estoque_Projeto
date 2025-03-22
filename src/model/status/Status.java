package model.status;

public enum Status {
    DISPONIVEL("Disponível"),
    ESTOQUE_BAIXO ("Estoque Baixo"),
    INDISPONIVEL("Indisponível");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
