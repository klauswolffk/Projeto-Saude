package View;

import Controller.MenuController;

import java.util.Scanner;

public class MenuView {
    private static Scanner ler = new Scanner(System.in);
    private static byte opcao;
    private static MenuController menucontroller;

    public MenuView(MenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("|----------MENU----------|\n" +
                           "|1. Cadastrar Médico     |\n" +
                           "|2. Listar Médico        |\n" +
                           "|3. Remover Médico       |\n" +
                           "|4. Atualizar Médico     |\n" +
                           "|5. a" );
        opcao = ler.nextByte();
        menucontroller.principalcontroller(opcao);

    }

}

