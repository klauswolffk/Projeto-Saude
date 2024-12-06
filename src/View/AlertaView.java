package View;

import Controller.AlertaController;
import Model.Alerta;
import Model.Medico;
import Model.Monitoramento;
import Model.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class AlertaView {
    private Scanner ler = new Scanner(System.in);
    AlertaController alertaController = new AlertaController();

    public void cadastrarAlerta() {
        Alerta alertaView = new Alerta();
        Medico medAlerta = new Medico();
        Paciente paciAlerta = new Paciente();
        Monitoramento monitorAlerta = new Monitoramento();

        System.out.println("Digite o CRM do médico responsável: ");
        medAlerta.setCrm(ler.next());

        System.out.println("Digite o CPF do paciente: ");
        paciAlerta.setCpf(ler.next());

        System.out.println("Digite o ID do monitoramento: ");
        monitorAlerta.setIdMonitoramento(ler.nextInt());

        System.out.println("Digite o tipo de alerta (Emergencia ou Anormalidade): ");
        alertaView.setTipoAlerta(ler.next());

        System.out.println("Digite a descrição do alerta: ");
        ler.nextLine();
        alertaView.setMensagem(ler.nextLine());

        System.out.println("Digite a data de registro do alerta (dd/mm/aaaa): ");
        alertaView.setData(ler.next());

        System.out.println("Digite o ID para o alerta: ");
        alertaView.setIdAlerta(ler.nextInt());

        String resultadoAlerta = alertaController.cadastrarAlerta(alertaView, medAlerta, paciAlerta, monitorAlerta);
        System.out.println(resultadoAlerta);
        MenuView.mostrarMenuPrincipal();
    }

    public void removerAlerta() {
        System.out.println("Digite o ID do alerta: ");
        int idAlert = ler.nextInt();
        String resultado = alertaController.removerAlerta(idAlert);
        System.out.println(resultado);
        MenuView.mostrarMenuPrincipal();
    }

    public void listarAlertas() {
        ArrayList<Alerta> listaAlertas = alertaController.listarAlerta();
        if (listaAlertas.isEmpty()) {
            System.out.println("Nenhum Alerta cadastrado.");
        } else {
            for (Alerta alerta : listaAlertas) {
                System.out.println("\nMedico: " + alerta.getMedico().getNome() +
                        "\nPaciente: " +  alerta.getPaciente().getNome()+
                        "\nMonitoramento: " +  alerta.getMonitoramento().getIdMonitoramento()+
                        "\nTipo do Alerta: " + alerta.getTipoAlerta() +
                        "\nDescrição: " + alerta.getMensagem() +
                        "\nData do Alerta: " + alerta.getData());
                System.out.println("");
            }
        }
        MenuView.mostrarMenuPrincipal();
    }
}
