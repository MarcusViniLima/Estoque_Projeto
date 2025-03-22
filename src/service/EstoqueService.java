package service;

import java.util.Random;

import dao.EstoqueDao;
import dao.ProdutoDao;
import model.EstoqueModel;
import model.FuncionarioModel;
import model.ProdutoModel;
import model.status.Classificacao;

public class EstoqueService {

    Random random = new Random();

    private ProdutoService produtoService = new ProdutoService();
    private ProdutoDao produtoDao = new ProdutoDao();
    private EstoqueDao dao = new EstoqueDao();

    public void retirarProduto(String idProduto, int quantidade, FuncionarioModel funcionario) {
        ProdutoModel produto = produtoService.buscar(idProduto);
        if(produto.getQuantidade() < quantidade) {    
            System.out.println("Quantidade insuficiente no estoque.");
            return;
        }
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoDao.atualizarStatusEstoque();
        dao.setEstoque(new EstoqueModel(dao.getEstoque().size()+1, produto, quantidade, funcionario, Classificacao.SAIDA));
    }

    public void adicionarProduto(String idProduto, int quantidade, FuncionarioModel funcionario) {
        ProdutoModel produto = produtoService.buscar(idProduto);
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        produtoDao.atualizarStatusEstoque();
        dao.setEstoque(new EstoqueModel(dao.getEstoque().size()+1, produto, quantidade, funcionario, Classificacao.ENTRADA));
    }
}
