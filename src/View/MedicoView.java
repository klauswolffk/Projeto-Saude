package View;

import Controller.MedicoController;
import Model.Medico;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicoView {

    private Scanner ler = new Scanner(System.in);
    private MedicoController medicocontroller = new MedicoController();

    public void cadastrarMedico() {
        Medico medicoview = new Medico(); // Criando uma nova instância do objeto Medico

        System.out.println("Digite o nome do Médico: ");
        medicoview.setNome(ler.next());

        System.out.println("Digite a especialidade do Médico: ");
        medicoview.setEspecialidade(ler.next());

        System.out.println("Digite o CRM do Médico: ");
        medicoview.setCrm(ler.next());

        System.out.println("Digite o E-mail do Médico: ");
        medicoview.setEmail(ler.next());

        System.out.println("Digite o telefone do Médico: ");
        medicoview.setTelefone(ler.next());

        // Chama o método do controller para registrar o médico
        System.out.println(medicocontroller.registrarmedico(medicoview));

        MenuView.mostrarMenuPrincipal(); // Volta para o menu principal
    }

    public void listarMedico() {
        ArrayList<Medico> listmedico = medicocontroller.listarMedicos();
        // Verifica se a lista está vazia
        if (listmedico.isEmpty()) {
            System.out.println("Não há médicos cadastrados.");
        } else {
        for (Medico medico : listmedico) {
            System.out.println("Nome: " + medico.getNome()
                    + "\nEspecialidade: " + medico.getEspecialidade()
                    + "\nCRM: " + medico.getCrm()
                    + "\nE-mail: " + medico.getEmail()
                    + "\nTelefone: " + medico.getTelefone());
            System.out.println(" ");
        }
        }
        MenuView.mostrarMenuPrincipal();
    }

    public void removerMedico() {
        System.out.println("Digite o CRM do Médico que deseja remover: ");
        String crm = ler.next();
        String resultado = medicocontroller.removerMedico(crm);
        System.out.println(resultado);
        MenuView.mostrarMenuPrincipal();
    }

    public void atualizarMedico() {
        System.out.println("Digite o CRM do Médico que deseja atualizar: ");
        String crm = ler.next();

        System.out.println("Digite o novo nome ou pressione Enter para manter: ");
        String nome = ler.next();

        System.out.println("Digite a nova especialidade ou pressione Enter para manter: ");
        ler.nextLine();
        String especialidade = ler.nextLine();

        System.out.println("Digite o novo e-mail ou pressione Enter para manter: ");
        String email = ler.nextLine();

        System.out.println("Digite o novo telefone ou pressione Enter para manter: ");
        String telefone = ler.nextLine();

        String resultado = medicocontroller.atualizarMedico(crm, nome, especialidade, email, telefone);
        System.out.println(resultado);

        MenuView.mostrarMenuPrincipal();
    }
}
