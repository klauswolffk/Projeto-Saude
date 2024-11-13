package View;
import Controller.MedicoController;
import Model.Medico;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicoView {

    private Scanner ler = new Scanner(System.in);

    private MedicoController medicocontroller = new MedicoController();



    public void cadastrarMedico() {
        Medico medicoview = new Medico();
        System.out.println("Digite o nome do medico: ");
        medicoview.setNome(ler.next());
        System.out.println("Digite a especialidade do médico: ");
        medicoview.setEspecialidade(ler.next());
        System.out.println("Digite o CRM do médico: ");
        medicoview.setCrm(ler.nextInt());
        System.out.println("Digite o E-mail do médico: ");
        medicoview.setEmail(ler.next());
        System.out.println("Digite o telefone do médico: ");
        medicoview.setTelefone(ler.next());
        System.out.println(medicocontroller.registrarmedico(medicoview));
        MenuView.mostrarMenuPrincipal();
    }
    public void listarMedico() {
        ArrayList<Medico> listmedico = medicocontroller.listarMedicos();
        for (Medico medico : listmedico) {
            System.out.println("Nome: " + medico.getNome()
                    + "\nEspecialidade: " + medico.getEspecialidade()
                    + "\nCRM: " + medico.getCrm()
                    + "\nE-mail: " + medico.getEmail()
                    + "\nTelefone: " + medico.getTelefone());
            System.out.println(" ");
        }
        MenuView.mostrarMenuPrincipal();
    }
}
