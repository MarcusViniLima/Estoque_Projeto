package dao;

import java.util.ArrayList;

import model.EstoqueModel;
import model.status.Classificacao;
import service.FuncionarioService;

public class EstoqueDao {

    private ArrayList<EstoqueModel> estoque = new ArrayList<EstoqueModel>();
    private ProdutoDao produtoDao;
    private FuncionarioService funcionarioService;

    public EstoqueDao(ProdutoDao produtoDao, FuncionarioService funcionarioService) {
        this.produtoDao = produtoDao;
        this.funcionarioService = funcionarioService;
        cadastro();
    }

    public void cadastro() {
        estoque.add(new EstoqueModel(1, produtoDao.buscar("1"), 50, funcionarioService.buscar("joao@joao"), Classificacao.ENTRADA));
        estoque.add(new EstoqueModel(2, produtoDao.buscar("2"), 70, funcionarioService.buscar("lucas@lucas"), Classificacao.ENTRADA));
        estoque.add(new EstoqueModel(3, produtoDao.buscar("3"), 30, funcionarioService.buscar("bruna@bruna"), Classificacao.ENTRADA));
    }

    public ArrayList<EstoqueModel> getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueModel estoque) {
        this.estoque.add(estoque);
    }
}
