package View;

import Controller.AgendaController;
import Model.Agenda;
import Model.Medicacoes;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaView {
    private AgendaController agendaController = new AgendaController();
    private Scanner ler = new Scanner(System.in);


    public void agendarConsulta() {
        Agenda agendaview = new Agenda();
        Medico crmAgenda = new Medico();
        Paciente cpfAgenda = new Paciente();
        Medicacoes idMedicacaoAgenda = new Medicacoes();
        System.out.println("Digite a data da consulta (dd/mm/aaaa):");
        agendaview.setData(ler.next());

        System.out.println("Digite a hora da consulta (hh:mm):");
        agendaview.setHora(ler.next());

        System.out.println("Digitar o CRM do médico responsável: ");
        crmAgenda.setCrm(ler.next());

        System.out.println("Digite o CPF do paciente: ");
        cpfAgenda.setCpf(ler.next());

        System.out.println("Digite o Diagnóstico: ");
        agendaview.setDiagnostico(ler.next());
        ler.nextLine();

        System.out.println("Digite o ID da medicação: ");
        idMedicacaoAgenda.setId(ler.nextInt());

        String resultadoAgenda = agendaController.realizarAgendamento(agendaview, cpfAgenda, crmAgenda, idMedicacaoAgenda);
        System.out.println(resultadoAgenda);
        MenuView.mostrarMenuPrincipal();
    }

    // Método para listar todas as medicações cadastradas
    public void listarAgenda() {
        ArrayList<Agenda> listaAgenda = agendaController.listarAgenda();

        if (listaAgenda.isEmpty()) {
            System.out.println("Nenhum Agendamento cadastrado.");
        } else {
            for (Agenda agenda : listaAgenda) {
                System.out.println("\nData: " + agenda.getData() +
                        "\nHora: " + agenda.getHora() +
                        "\nMédico Responsável: " + agenda.getMedico().getNome() +
                        "\nCPF do Paciente: " + agenda.getPaciente().getNome() +
                        "\nDiagnóstico: " + agenda.getDiagnostico() +
                        "\nMedicação: " + agenda.getPaciente().getMedicacoes().getNome());
                System.out.println("");
            }
        }
        MenuView.mostrarMenuPrincipal();
    }

}
