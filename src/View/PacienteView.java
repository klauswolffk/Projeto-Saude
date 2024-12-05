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
            if (listpaciente.isEmpty()) {
                System.out.println("Nenhum paciente cadastrado! ");
            } else {
                System.out.println(
                        "PACIENTES\n"
                                + "Nome: " + paciente.getNome()
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

        // Método para alterar os dados do paciente
        public void alterarPaciente(){
            System.out.println("Digite o CPF do paciente que deseja alterar:");
            String cpf = scanner.nextLine();

            // Verificando se o paciente existe, caso contrário, mostrando mensagem de erro
            ArrayList<Paciente> pacientes = pacienteController.listarPacientes();
            Paciente pacienteEncontrado = null;

            // Procurando o paciente pelo CPF
            for (Paciente paciente : pacientes) {
                if (paciente.getCpf().equals(cpf)) {
                    pacienteEncontrado = paciente;
                    break;
                }
            }

            // Se o paciente foi encontrado, permite a alteração dos dados
            if (pacienteEncontrado != null) {
                // Solicitando os novos dados para o paciente
                System.out.println("Digite o novo nome do paciente (ou pressione Enter para manter o atual):");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) pacienteEncontrado.setNome(nome);

                System.out.println("Digite a nova data de nascimento do paciente (dd/mm/aaaa) (ou pressione Enter para manter o atual):");
                String dataNascimento = scanner.nextLine();
                if (!dataNascimento.isEmpty()) pacienteEncontrado.setDataNascimento(dataNascimento);

                System.out.println("Digite o novo endereço do paciente (ou pressione Enter para manter o atual):");
                String endereco = scanner.nextLine();
                if (!endereco.isEmpty()) pacienteEncontrado.setEndereco(endereco);

                System.out.println("Digite o novo telefone do paciente (ou pressione Enter para manter o atual):");
                String telefone = scanner.nextLine();
                if (!telefone.isEmpty()) pacienteEncontrado.setTelefone(telefone);

                System.out.println("Digite o novo e-mail do paciente (ou pressione Enter para manter o atual):");
                String email = scanner.nextLine();
                if (!email.isEmpty()) pacienteEncontrado.setEmail(email);

                System.out.println("Digite o novo histórico de doenças do paciente (ou pressione Enter para manter o atual):");
                String historico = scanner.nextLine();
                if (!historico.isEmpty()) pacienteEncontrado.setHistorico(historico);

                // Chamando o método no controlador para atualizar os dados
                String resultado = pacienteController.alterarDadosPaciente(cpf, pacienteEncontrado);
                System.out.println(resultado);
            } else {
                // Se o paciente não foi encontrado
                System.out.println("Paciente não encontrado.");
            }

            // Retorna ao menu principal
            MenuView.mostrarMenuPrincipal();
        }




}
