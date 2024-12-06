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
        System.out.println("|-------------------MENU-------------------|\n" +
                           "|1.   Cadastrar Médico                     |\n" +
                           "|2.   Listar Médico                        |\n" +
                           "|3.   Remover Médico                       |\n" +
                           "|4.   Atualizar Médico                     |\n" +
                           "|5.   Cadastrar Dispositivo                |\n" +
                           "|6.   Listar Dispositivos                  |\n" +
                           "|7.   Remover Dispositivos                 |\n" +
                           "|8.   Cadastrar Paciente                   |\n" +
                           "|9.   Atualizar Paciente                   |\n" +
                           "|10.  Listar Paciente                      |\n" +
                           "|11.  Cadastrar Medicações                 |\n" +
                           "|12.  Alterar Dosagem                      |\n" +
                           "|13.  Remover Medicações                   |\n" +
                           "|14.  Listar Medicações                    |\n" +
                           "|15.  Agendar Consulta                     |\n" +
                           "|16.  Listar Consultas                     |\n" +
                           "|17.  Registrar Monitoramento              |\n" +
                           "|18.  Listar Monitoramentos                |\n" +
                           "|19.  Cadastrar Alerta                     |\n" +
                           "|20.  Remover Alerta                       |\n" +
                           "|21.  Listar Alerta                        |\n" +
                           "|------------------------------------------|\n" +
                "\n" +
                "\n" );
        opcao = ler.nextByte();
        menucontroller.principalcontroller(opcao);

    }

}

