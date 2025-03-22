package dao;

import model.FuncionarioModel;

import java.util.ArrayList;

public class FuncionarioDao {

    private ArrayList<FuncionarioModel> funcionarios = new ArrayList<FuncionarioModel>();

    public FuncionarioDao() {
        cadastro();
    }

    public void cadastro() {
        funcionarios.add(new FuncionarioModel(1, "Joao", "joao@joao", "123456"));
        funcionarios.add(new FuncionarioModel(2, "Lucas", "lucas@lucas", "123456"));
        funcionarios.add(new FuncionarioModel(3, "Bruna", "bruna@bruna", "123456"));
    }

    public ArrayList<FuncionarioModel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(FuncionarioModel funcionario) {
        this.funcionarios.add(funcionario);
    }

}
