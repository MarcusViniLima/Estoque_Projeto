import service.FuncionarioService;

public class Main {
    public static void main(String[] args) {

        FuncionarioService service = new FuncionarioService();
        service.listar();
        service.buscar(2);
        service.deletar(2);
        service.buscar(2);
        service.listar();
    }
}