package service;
import dao.EstoqueDao;
import dao.ProdutoDao;
import model.EstoqueModel;
import model.FuncionarioModel;
import model.ProdutoModel;
import model.status.Classificacao;
import model.status.Status;

public class ProdutoService {

    private ProdutoDao produtoDao;
    private EstoqueDao estoqueDao;

    public ProdutoService(ProdutoDao produtoDao, EstoqueDao estoqueDao) {
        this.produtoDao = produtoDao;
        this.estoqueDao = estoqueDao;
    }

    public void listar() {
        for (ProdutoModel produto : produtoDao.getProdutos()) {
            System.out.println(produto);
        }
    }

    public void listarProdutoEstoqueBaixo() {
        for (ProdutoModel produto : produtoDao.getProdutos()) {
            if (produto.getStatus() == Status.ESTOQUE_BAIXO) {
                System.out.println(produto);
            }
        }
    }

    public ProdutoModel buscar(String id) {
        for (ProdutoModel produto : produtoDao.getProdutos()) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }

        System.out.println("Produto não encontrado.");
        return null;
    }

    public void cadastrar(String id, String nome, int quantidade, double precoUnitario, String categoria, Status status) {
        for (ProdutoModel produto : produtoDao.getProdutos()) {
            if (produto.getId().equals(id)) {
                System.out.println("Produto ja cadastrado.");
                return;
            }
        }
        produtoDao.setProdutos(new ProdutoModel(id, nome, quantidade, precoUnitario, categoria, status));
    } 
    
    

    public void retirarProduto(String idProduto, int quantidade, FuncionarioModel funcionario) {
        for (int i = 0; i < produtoDao.getProdutos().size(); i++) {
            if (produtoDao.getProdutos().get(i).getId().equals(idProduto)) {
                int quantidadeDisponivel = produtoDao.getProdutos().get(i).getQuantidade();
                if (quantidadeDisponivel < quantidade) {
                    System.out.println("Quantidade indisponível.");
                    return;
                }
                produtoDao.getProdutos().get(i)
                        .setQuantidade(produtoDao.getProdutos().get(i).getQuantidade() - quantidade);
                System.out.println("Quantidade atualizada: " + produtoDao.getProdutos().get(i).getQuantidade());
                produtoDao.atualizarStatusEstoque();
                estoqueDao.getEstoque().add(new EstoqueModel(
                estoqueDao.getEstoque().size() + 1,
                produtoDao.getProdutos().get(i),
                quantidade,
                funcionario,
                Classificacao.SAIDA
            ));
                return;
            }

        }

    }

    public void adicionarProduto(String idProduto, int quantidade, FuncionarioModel funcionario) {
        ProdutoModel produto = this.buscar(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        produtoDao.atualizarStatusEstoque();
        estoqueDao.setEstoque(
                new EstoqueModel(estoqueDao.getEstoque().size() + 1, produto, quantidade, funcionario, Classificacao.ENTRADA));
    }

    public void listarEstoque() {
        for (EstoqueModel estoque : estoqueDao.getEstoque()) {
            System.out.println(estoque);
        }
    }

}
