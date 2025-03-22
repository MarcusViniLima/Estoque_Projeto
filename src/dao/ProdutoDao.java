package dao;

import java.util.ArrayList;

import model.ProdutoModel;
import model.status.Status;

public class ProdutoDao {

    private ArrayList<ProdutoModel> produtos = new ArrayList<ProdutoModel>();

    public ProdutoDao() {
        cadastro();
    }

    public void cadastro() {
        produtos.add(new ProdutoModel("1", "Camiseta Vermelha", 50, 49.90, "Roupas", Status.DISPONIVEL));
        produtos.add(new ProdutoModel("2", "Camiseta Azul", 70, 49.90, "Roupas", Status.DISPONIVEL));
        produtos.add(new ProdutoModel("3", "Camiseta Preta", 30, 49.90, "Roupas", Status.DISPONIVEL));

        atualizarStatusEstoque();
    }
    

    public ArrayList<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(ProdutoModel produto) {
        this.produtos.add(produto);
    }

    public void atualizarStatusEstoque() {
        for (ProdutoModel produto : produtos) {
            if (produto.getQuantidade() < 15) {
                produto.setStatus(Status.ESTOQUE_BAIXO);
            } if(produto.getQuantidade() == 0) {
                produto.setStatus(Status.INDISPONIVEL);
            }
            if (produto.getQuantidade() > 15) {
                produto.setStatus(Status.DISPONIVEL);
            }
        }
    }

}
