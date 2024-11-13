package View;

import Controller.DispositivosController;
import Model.Dispositivos;

import java.util.Scanner;

public class DispositivoView {

    private Scanner ler = new Scanner(System.in);
    private DispositivosController dispositivoController = new DispositivosController();

    public void cadastrarDispositivo() {
        System.out.println("Digite o tipo do dispositivo: ");
        String tipo = ler.nextLine();

        System.out.println("Digite a marca do dispositivo: ");
        String marca = ler.nextLine();

        System.out.println("Digite o modelo do dispositivo: ");
        String modelo = ler.nextLine();

        // Captura o status como string e converte para boolean
        boolean status = false;
        while (true) {
            System.out.println("Digite o status do dispositivo (true para ativo, false para inativo): ");
            String statusInput = ler.nextLine().toLowerCase();

            if (statusInput.equals("true")) {
                status = true;
                break;
            } else if (statusInput.equals("false")) {
                status = false;
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, digite 'true' para ativo ou 'false' para inativo.");
            }
        }

        System.out.println("Digite os valores de referência do dispositivo: ");
        String valoresReferencia = ler.nextLine();

        // Criação do objeto Dispositivo e definição de seus valores
        Dispositivos dispositivo = new Dispositivos();
        dispositivo.setTipo(tipo);
        dispositivo.setMarca(marca);
        dispositivo.setModelo(modelo);
        dispositivo.setStatus(status);
        dispositivo.setValoresReferencia(valoresReferencia);

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
