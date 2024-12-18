package Controller;


import Model.Medico;
import Model.Paciente;
import java.util.ArrayList;


public class PacienteController {

    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    // Método para registrar um paciente
    public String registrarPaciente(Paciente paciente) {
        // Verificar se o paciente já está cadastrado pelo CPF
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(paciente.getCpf())) {
                return "Paciente já cadastrado.";
            }
        }

        // Verificar se os dados obrigatórios estão preenchidos
        if (paciente.getNome() == null || paciente.getNome().isEmpty()) {
            return "Nome do paciente é obrigatório.";
        }
        if (paciente.getCpf() == null || paciente.getCpf().isEmpty()) {
            return "CPF do paciente é obrigatório.";
        }
        if (paciente.getDataNascimento() == null || paciente.getDataNascimento().isEmpty()) {
            return "Data de nascimento do paciente é obrigatória.";
        }
        if (paciente.getEndereco() == null || paciente.getEndereco().isEmpty()) {
            return "Endereço do paciente é obrigatório.";
        }
        if (paciente.getTelefone() == null || paciente.getTelefone().isEmpty()) {
            return "Telefone do paciente é obrigatório.";
        }
        if (paciente.getEmail() == null || paciente.getEmail().isEmpty()) {
            return "E-mail do paciente é obrigatório.";
        }

        pacientes.add(paciente);
        return "Paciente registrado com sucesso!";
    }

    // Método para alterar os dados do paciente
    public String alterarDadosPaciente(String cpf, Paciente novosDados) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                // Alterando os dados do paciente
                p.setNome(novosDados.getNome());
                p.setDataNascimento(novosDados.getDataNascimento());
                p.setEndereco(novosDados.getEndereco());
                p.setTelefone(novosDados.getTelefone());
                p.setEmail(novosDados.getEmail());
                return "Dados do paciente alterados com sucesso!";
            }
        }
        return "Paciente não encontrado.";
    }

    public ArrayList<Paciente> listarPacientes() {
        return this.pacientes;
    }
    public static Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }



}
