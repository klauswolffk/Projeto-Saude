package View;

import Controller.DispositivosController;
import Model.Dispositivos;

import java.util.Scanner;

public class DispositivoView {

    private Scanner ler = new Scanner(System.in);
    private DispositivosController dispositivoController = new DispositivosController();

    public void cadastrarDispositivo(Dispositivos dispositivo) {
        System.out.println("Digite o tipo do dispositivo: ");
        dispositivo.setTipo(ler.nextLine());  // Alterado para nextLine()

        System.out.println("Digite a marca do dispositivo: ");
        dispositivo.setMarca(ler.nextLine());  // Alterado para nextLine()

        System.out.println("Digite o modelo do dispositivo: ");
        dispositivo.setModelo(ler.nextLine());  // Alterado para nextLine()

        System.out.println("Digite os valores de referência do dispositivo: ");
        dispositivo.setValoresReferencia(ler.nextLine());  // Alterado para nextLine()

        // Chama o método do Controller para cadastrar o dispositivo
        String resultado = dispositivoController.cadastrarDispositivo(dispositivo);
        System.out.println(resultado);
        MenuView.mostrarMenuPrincipal();
    }

    public void listarDispositivos() {
        // Exibe a lista de dispositivos cadastrados
        String dispositivos = dispositivoController.visualizarDispositivos();
        System.out.println(dispositivos);
        MenuView.mostrarMenuPrincipal();
    }

    public void removerDispositivo() {
        System.out.println("Digite o modelo do dispositivo que deseja remover: ");
        String modelo = ler.nextLine();
        String resultado = dispositivoController.removerDispositivo(modelo);
        System.out.println(resultado);
        MenuView.mostrarMenuPrincipal();
    }
}
