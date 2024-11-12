package View;
import Model.Medico;
import java.util.Scanner;

public class MedicoView {

    Scanner ler = new Scanner(System.in);
    Medico medicoview = new Medico();

    private void cadastrarMedico(byte opcao) {
        System.out.println("Digite o nome do medico: ");
        medicoview.setNome(ler.nextLine());
        System.out.println("Digite a especialidade do médico: ");
        medicoview.setEspecialidade(ler.nextLine());
        System.out.println("Digite o CRM do médico: ");
        medicoview.setCrm(ler.nextInt());
        System.out.println("Digite o E-mail do médico: ");
        medicoview.setEmail(ler.nextLine());
        System.out.println("Digite o telefone do médico: ");
        medicoview.setTelefone(ler.nextLine());



    }
}
