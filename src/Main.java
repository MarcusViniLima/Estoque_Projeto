import service.MenuService;


public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        if (menuService.fazerLogin()) {
            menuService.menuPrincipal();
        } else {
            System.out.println("Falha no login. Tente novamente.");
        }

    }


}           
