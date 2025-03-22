package service;

import dao.FuncionarioDao;
import model.FuncionarioModel;

import java.util.ArrayList;

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

    public boolean cadastrar(String nome, String email, String senha) {
        FuncionarioModel funcionario = new FuncionarioModel(dao.getFuncionarios().size() + 1, nome, email, senha);
        dao.setFuncionarios(funcionario);
        return true;
    }

    public void listar() {
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            System.out.println(funcionario);
        }
    }

    public void buscar(int id) {
        boolean encontrado = false;
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getId() == id) {
                System.out.println(funcionario);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
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
