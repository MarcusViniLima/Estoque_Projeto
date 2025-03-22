package model.status;

public enum Classificacao {
    ENTRADA("Entrada"), SAIDA("Saida");

    private String descricao;

    Classificacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
