import Controller.MenuController;
import View.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuController menucontroller = new MenuController();
        MenuView menuview = new MenuView(menucontroller);
        menuview.mostrarMenuPrincipal();

    }
}