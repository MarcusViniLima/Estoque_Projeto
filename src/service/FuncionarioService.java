package service;

import dao.FuncionarioDao;
import model.FuncionarioModel;


public class FuncionarioService {

    private FuncionarioDao dao = new FuncionarioDao();

    public boolean login(String email, String senha) {
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public void cadastrar(String nome, String email, String senha) {
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getEmail().equals(email)) {
                System.out.println("Funcionario ja cadastrado.");
            }
        }
        FuncionarioModel funcionario = new FuncionarioModel(dao.getFuncionarios().size() + 1, nome, email, senha);
        dao.setFuncionarios(funcionario);

    }

    public void listar() {
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            System.out.println(funcionario);
        }
    }

    public FuncionarioModel buscar(String email) {
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getEmail() == email) {
                return funcionario;
            }
        }

        System.out.println("Funcionário nao encontrado.");
        return null;
    }

    public boolean atualizar(int id, String nome, String email, String senha) {
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getId() == id) {
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setSenha(senha);
                return true;
            }
        }
        return false;
    }

    public void deletar(int id) {
        boolean encontrado = false;
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getId() == id) {
                dao.getFuncionarios().remove(funcionario);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }
}
