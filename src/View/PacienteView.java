package View;

import Controller.PacienteController;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class PacienteView {

    private Scanner scanner = new Scanner(System.in);
    private PacienteController pacienteController = new PacienteController();

    // Método para cadastrar um paciente
    public void cadastrarPaciente(Paciente paciente) {
        System.out.println("Digite o nome do paciente:");
        String nome = scanner.nextLine();


        System.out.println("Digite o CPF do paciente:");
        String cpf = scanner.nextLine();

        System.out.println("Digite a data de nascimento do paciente (dd/mm/aaaa):");
        String dataNascimento = scanner.nextLine();

        System.out.println("Digite o endereço do paciente:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o telefone do paciente:");
        String telefone = scanner.nextLine();

        System.out.println("Digite o e-mail do paciente:");
        String email = scanner.nextLine();

        System.out.println("Digite o histórico de doenças do paciente:");
        String historico = scanner.nextLine();

        // Criando o objeto Paciente e configurando seus atributos
        paciente.setNome(nome);
        paciente.setCpf(cpf);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setHistorico(historico);

        // Chamando o método para registrar o paciente
        String resultado = pacienteController.registrarPaciente(paciente);
        System.out.println(resultado);
        MenuView.mostrarMenuPrincipal();
    }

    public void listarPaciente() {
        ArrayList<Paciente> listpaciente = pacienteController.listarPacientes();
        for (Paciente paciente : listpaciente) {
            System.out.println(
                    "PACIENTES"
                    +   "Nome: " + paciente.getNome()
                    + "\nCPF: " + paciente.getCpf()
                    + "\nData de Nascimento: " + paciente.getDataNascimento()
                    + "\nEndereço: " + paciente.getEndereco()
                    + "\nTelefone: " + paciente.getTelefone()
                    + "\nE-mail: " + paciente.getEmail()
                    + "\nHistórico de doenças: " + paciente.getHistorico());
            System.out.println(" ");
        }
        MenuView.mostrarMenuPrincipal();
    }




}
