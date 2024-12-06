package View;

import Controller.MonitoramentoController;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MonitoramentoView {
    private Scanner ler = new Scanner(System.in);
    private MonitoramentoController monitoramentoController = new MonitoramentoController();

    public void cadastrarMonitoramento() {
        Monitoramento monitoramentoview = new Monitoramento();
        Medico crmMoni = new Medico();
        Dispositivos disposiMoni = new Dispositivos();
        Paciente pacMoni = new Paciente();

        System.out.println("Digite o CRM do médico responsável: ");
        crmMoni.setCrm(ler.next());

        System.out.println("Digite o id do monitoramento: ");
        monitoramentoview.setIdMonitoramento(ler.nextInt());

        System.out.println("Digite o Modelo do dispositivo: ");
        disposiMoni.setModelo(ler.next());

        System.out.println("Digite os dados de monitoramento do dispositivo: ");
        monitoramentoview.setDadosmonitoramento(ler.next());
        ler.nextLine();

        System.out.println("Digite o CPF do paciente: ");
        pacMoni.setCpf(ler.next());

        String resultMoni = monitoramentoController.cadastrarMonitoramento(monitoramentoview, crmMoni, pacMoni, disposiMoni);
        System.out.println(resultMoni);
        MenuView.mostrarMenuPrincipal();
    }

    public void listarMonitoramentos() {
        ArrayList<Monitoramento> listaMonitoramentos = monitoramentoController.listarMonitoramentos();
        if (listaMonitoramentos.isEmpty()) {
            System.out.println("Nenhum monitoramento cadastrado.");
        } else {
            for (Monitoramento monitoramento : listaMonitoramentos) {
                System.out.println("\nPaciente: " + monitoramento.getPaciente().getNome() +
                        "\nDispositivo: " + monitoramento.getDispositivos().getTipo() +
                        "\nDados de Monitoração: " + monitoramento.getDadosmonitoramento());
                System.out.println("");
            }
        }
        MenuView.mostrarMenuPrincipal();
    }
}
