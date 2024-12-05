package View;

import Controller.MedicacoesController;
import Controller.MedicoController;
import Model.Medicacoes;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicacoesView {

    private  Scanner scanner = new Scanner(System.in);
    private  MedicacoesController medicacoesController = new MedicacoesController();

    // Método para cadastrar uma medicação
    public void cadastrarMedicacao() {
        Medicacoes medicacao = new Medicacoes();
        System.out.println("Digite o ID da medicação:");
        medicacao.setId(scanner.nextInt());

        System.out.println("Digite o nome da medicação:");
        medicacao.setNome(scanner.next());

        System.out.println("Digite a dosagem da medicação:");
        medicacao.setDosagem(scanner.next());

        System.out.println("Digite a frequência da medicação:");
        medicacao.setFrequencia(scanner.next());

        System.out.println("Digite a descrição da medicação:");
        medicacao.setDescricao(scanner.next());

        System.out.println("Digite a data de prescrição da medicação (dd/mm/aaaa):");
        medicacao.setDataPrescricao(scanner.next());

        // Chamar o controlador para registrar a medicação
        String resultado = medicacoesController.cadastrarMedicacao(medicacao);
        System.out.println(resultado);
        MenuView.mostrarMenuPrincipal();
    }

    // Método para listar todas as medicações cadastradas
    public void listarMedicacoes() {
        ArrayList<Medicacoes> listaMedicacoes = medicacoesController.listarMedicacoes();

        if (listaMedicacoes.isEmpty()) {
            System.out.println("Nenhuma medicação cadastrada.");
        } else {
            for (Medicacoes medicacao : listaMedicacoes) {
                System.out.println("\nID: " + medicacao.getId() +
                        "\nNome: " + medicacao.getNome() +
                        "\nDosagem: " + medicacao.getDosagem() +
                        "\nFrequência: " + medicacao.getFrequencia() +
                        "\nDescrição: " + medicacao.getDescricao() +
                        "\nData de Prescrição: " + medicacao.getDataPrescricao());
                System.out.println("");
            }
        }
        MenuView.mostrarMenuPrincipal();
    }

    // Método para remover uma medicação pelo ID
    public void removerMedicacao() {
        System.out.println("Digite o ID da medicação a ser removida:");
        int id = scanner.nextInt();

        // Chama o método do Controller para remover a medicação
        String resultadoRemocao = medicacoesController.removerMedicacaoPorId(id);
        System.out.println(resultadoRemocao);
        MenuView.mostrarMenuPrincipal();
    }

    // Método para alterar a dosagem de uma medicação
    public void alterarDosagem() {
        scanner.nextLine();
        System.out.println("Digite o ID da medicação que deseja alterar:");
        String id = scanner.nextLine();

        System.out.println("Digite a nova dosagem:");
        String novaDosagem = scanner.nextLine();

        String resultado = medicacoesController.alterarDosagem(id, novaDosagem);
        System.out.println(resultado);
        MenuView.mostrarMenuPrincipal();
    }
}
