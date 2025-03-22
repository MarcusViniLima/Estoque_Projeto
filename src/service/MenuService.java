package service;

import java.util.Scanner;

import dao.EstoqueDao;
import dao.ProdutoDao;
import model.FuncionarioModel;
import model.ProdutoModel;
import model.status.Status;

public class MenuService {

    private FuncionarioService funcionarioService = new FuncionarioService();
    private ProdutoService produtoService;
    private Scanner scanner = new Scanner(System.in);

    private FuncionarioModel funcionarioLogado;

    public MenuService() {
        ProdutoDao produtoDao = new ProdutoDao();
        EstoqueDao estoqueDao = new EstoqueDao(produtoDao, funcionarioService);
        produtoService = new ProdutoService(produtoDao, estoqueDao);
    }

    public boolean fazerLogin() {
        System.out.println("------ LOGIN ------");
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (funcionarioService.login(email, senha)) {
            funcionarioLogado = funcionarioService.buscar(email);
            System.out.println("Login bem-sucedido!");
            return true;
        } else {
            System.out.println("Credenciais incorretas.");
        }
        return false;
    }

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n-------- MENU --------");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Buscar Funcionário");
            System.out.println("3. Listar Funcionários");
            System.out.println("4. Cadastrar Produto");
            System.out.println("5. Buscar Produto");
            System.out.println("6. Listar Produtos");
            System.out.println("7. Retirar Produto do Estoque");
            System.out.println("8. Adicionar Produto ao Estoque");
            System.out.println("9. Listar Produtos com Estoque Baixo");
            System.out.println("10.Listar Entradas e Saidas");
            System.out.println("11. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    buscarFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    cadastrarProduto();
                    break;
                case 5:
                    buscarProduto();
                    break;
                case 6:
                    listarProdutos();
                    break;
                case 7:
                    retirarProdutoEstoque();
                    break;
                case 8:
                    adicionarProdutoEstoque();
                    break;
                case 9:
                    listarProdutosEstoqueBaixo();
                    break;
                case 10:
                    listarEntradasSaidas();
                    break;
                case 11:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 11);
    }

    public void cadastrarFuncionario() {
        System.out.println("\n------ CADASTRO DE FUNCIONÁRIO ------");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        funcionarioService.cadastrar(nome, email, senha);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void buscarFuncionario() {
        System.out.println("\n------ BUSCA DE FUNCIONÁRIO ------");
        System.out.print("Digite o email do funcionário: ");
        String email = scanner.nextLine();

        FuncionarioModel funcionario = funcionarioService.buscar(email);
        if (funcionario != null) {
            System.out.println(funcionario);
        }
    }

    public void listarFuncionarios() {
        System.out.println("\n------ LISTA DE FUNCIONÁRIOS ------");
        funcionarioService.listar();
    }

    public void cadastrarProduto() {
        System.out.println("\n------ CADASTRO DE PRODUTO ------");
        System.out.print("Digite o ID do produto: ");
        String id = scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o preço unitário: ");
        double precoUnitario = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite o status (ATIVO, INATIVO, ESTOQUE_BAIXO): ");
        String statusStr = scanner.nextLine();
        Status status = Status.valueOf(statusStr);

        produtoService.cadastrar(id, nome, quantidade, precoUnitario, categoria, status);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void buscarProduto() {
        System.out.println("\n------ BUSCA DE PRODUTO ------");
        System.out.print("Digite o ID do produto: ");
        String id = scanner.nextLine();

        ProdutoModel produto = produtoService.buscar(id);
        if (produto != null) {
            System.out.println(produto);
        }
    }

    public void listarProdutos() {
        System.out.println("\n------ LISTA DE PRODUTOS ------");
        produtoService.listar();
    }

    public void retirarProdutoEstoque() {
        System.out.println("\n------ RETIRAR PRODUTO DO ESTOQUE ------");
        System.out.print("Digite o ID do produto: ");
        String idProduto = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        FuncionarioModel funcionario = obterFuncionario();
        produtoService.retirarProduto(idProduto, quantidade, funcionario);
    }

    public void adicionarProdutoEstoque() {
        System.out.println("\n------ ADICIONAR PRODUTO AO ESTOQUE ------");
        System.out.print("Digite o ID do produto: ");
        String idProduto = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        FuncionarioModel funcionario = obterFuncionario();
        produtoService.adicionarProduto(idProduto, quantidade, funcionario);
    }

    public FuncionarioModel obterFuncionario() {
        return funcionarioLogado;
    }

    public void listarProdutosEstoqueBaixo() {
        System.out.println("\n------ LISTA DE PRODUTOS COM ESTOQUE BAIXO ------");
        produtoService.listarProdutoEstoqueBaixo();
    }

    public void listarEntradasSaidas() {
        System.out.println("\n------ LISTA DE ENTRADAS E SAIDAS ------");
        produtoService.listarEstoque();
    }
}
