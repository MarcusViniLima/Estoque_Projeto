package model;

import model.status.Classificacao;

public class EstoqueModel {

    private int id;
    private ProdutoModel produto;
    private int quantidade;
    private FuncionarioModel funcionario;
    private Classificacao tipo;

    public EstoqueModel(int id, ProdutoModel produto, int quantidade, FuncionarioModel funcionario, Classificacao tipo) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.funcionario = funcionario;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) { 
        this.id = id;
    }    

    public ProdutoModel getProduto() {    
        return produto;
    }    

    public void setProduto(ProdutoModel produto) {    
        this.produto = produto;
    }    

    public int getQuantidade() {    
        return quantidade;
    }        

    public void setQuantidade(int quantidade) {        
        this.quantidade = quantidade;
    }    

    public FuncionarioModel getFuncionario() {    
        return funcionario;
    }    

    public void setFuncionario(FuncionarioModel funcionario) {    
        this.funcionario = funcionario;
    }

    public Classificacao getTipo() {
        return tipo;
    }

    public void setTipo(Classificacao tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "EstoqueModel [id=" + id + ", produto=" + produto.getId() + ", quantidade=" + quantidade + ", funcionario=" + funcionario.getNome() + ", tipo=" + tipo + "]";
    }
}
