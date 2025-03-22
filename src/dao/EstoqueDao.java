package dao;

import java.util.ArrayList;

import model.EstoqueModel;
import model.status.Classificacao;
import service.FuncionarioService;
import service.ProdutoService;

public class EstoqueDao {

    private ArrayList<EstoqueModel> estoque = new ArrayList<EstoqueModel>();
    private ProdutoService produtoService = new ProdutoService();
    private FuncionarioService funcionarioService = new FuncionarioService();

    public EstoqueDao() {
        cadastro();    
    }

    public void cadastro() {
        estoque.add(new EstoqueModel(1, produtoService.buscar("1"), 10, funcionarioService.buscar("joao@joao"), Classificacao.ENTRADA));
        estoque.add(new EstoqueModel(2, produtoService.buscar("2"), 10, funcionarioService.buscar("lucas@lucas"), Classificacao.ENTRADA));
        estoque.add(new EstoqueModel(3, produtoService.buscar("3"), 10, funcionarioService.buscar("bruna@bruna"), Classificacao.ENTRADA));

        estoque.add(new EstoqueModel(4, produtoService.buscar("2"), 15, funcionarioService.buscar("lucas@lucas"), Classificacao.SAIDA));
        estoque.add(new EstoqueModel(5, produtoService.buscar("3"), 15, funcionarioService.buscar("bruna@bruna"), Classificacao.SAIDA));
         
    }

    public ArrayList<EstoqueModel> getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueModel estoque) {
        this.estoque.add(estoque);
    }
}
