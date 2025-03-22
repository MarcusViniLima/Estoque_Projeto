package service;

import dao.ProdutoDao;
import model.ProdutoModel;
import model.status.Status;

public class ProdutoService {

    private ProdutoDao dao = new ProdutoDao();

    public void listar() {
        for (ProdutoModel produto : dao.getProdutos()) {
            System.out.println(produto);
        }
    }

    public void listarProdutoEstoqueBaixo() {
        for (ProdutoModel produto : dao.getProdutos()) {
            if (produto.getStatus() == Status.ESTOQUE_BAIXO) {
                System.out.println(produto);
            }
        }
    }

    public ProdutoModel buscar(String id) {
        for (ProdutoModel produto : dao.getProdutos()) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }

        System.out.println("Produto não encontrado.");
        return null;
    }

    public void cadastrar(String id, String nome, int quantidade, double precoUnitario, String categoria, Status status) {
        for (ProdutoModel produto : dao.getProdutos()) {
            if (produto.getId().equals(id)) {
                System.out.println("Produto ja cadastrado.");
                return;
            }
        }
        dao.setProdutos(new ProdutoModel(id, nome, quantidade, precoUnitario, categoria, status));
    }   

    public void atualizar(String id, String nome, double precoUnitario, String categoria, Status status) {
        for (ProdutoModel produto : dao.getProdutos()) {
            if (produto.getId().equals(id)) {
                produto.setNome(nome);
                produto.setPrecoUnitario(precoUnitario);
                produto.setCategoria(categoria);
                produto.setStatus(status);
                break;
            }
        }
    }

    public void deletar(String id) {
        boolean encontrado = false;
        for (ProdutoModel produto : dao.getProdutos()) {
            if (produto.getId().equals(id)) {
                dao.getProdutos().remove(produto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto nao encontrado.");
        }
    }

    

}
