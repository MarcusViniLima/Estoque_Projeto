package service;

import dao.FuncionarioDao;
import model.FuncionarioModel;


public class FuncionarioService {

    private FuncionarioDao dao = new FuncionarioDao();

    public boolean login(String email, String senha) {
        System.out.println("Buscando o funcionário...");
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return true;  // Se encontrar, retorna true
            }
        }
        return false; // Se não encontrar, retorna false
    }

    public void cadastrar(String nome, String email, String senha) {
        for (FuncionarioModel funcionario : dao.getFuncionarios()) {
            if (funcionario.getEmail().equals(email)) {
                System.out.println("Funcionario ja cadastrado.");
                return;
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
            if (funcionario.getEmail().equals(email)) {
                return funcionario;  
            }
        }
        return null;  
    }

}
