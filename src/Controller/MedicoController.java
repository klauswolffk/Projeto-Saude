package Controller;

import Model.Medico;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicoController {

    private ArrayList<Medico> medicos = new ArrayList<>();

    // Método para registrar médico
    public String registrarmedico(Medico medico) {
        // 1. Validação de CRM único
        for (Medico m : medicos) {
            if (m.getCrm() == medico.getCrm()) {
                return "CRM já está cadastrado.";
            }
        }

        // 2. Validação de campos obrigatórios
        if (medico.getNome() == null || medico.getNome().isEmpty()) {
            return "Nome do médico é obrigatório.";
        }
        if (medico.getEspecialidade() == null || medico.getEspecialidade().isEmpty()) {
            return "Especialidade do médico é obrigatória.";
        }
        if (medico.getEmail() == null || medico.getEmail().isEmpty() || !isValidEmail(medico.getEmail())) {
            return "E-mail inválido.";
        }
        if (medico.getTelefone() == null || medico.getTelefone().isEmpty() || !isValidTelefone(medico.getTelefone())) {
            return "Telefone inválido.";
        }

        // Adiciona o médico à lista
        medicos.add(medico);
        return "Médico cadastrado com sucesso!";
    }

    // Método para listar médicos
    public ArrayList<Medico> listarMedicos() {
        return this.medicos;
    }

    // Método para validar e-mail
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Método para validar telefone
    private boolean isValidTelefone(String telefone) {
        return telefone.matches("\\d{10,11}"); // Exemplo: telefone de 10 ou 11 dígitos
    }

    // Método para remover médico pelo CRM
    public String removerMedico(int crm) {
        // Procura o médico com o CRM informado
        for (Medico m : medicos) {
            if (m.getCrm() == crm) {
                // Remove o médico da lista
                medicos.remove(m);
                return "Médico removido com sucesso!";
            }
        }
        // Caso não encontre o médico
        return "CRM não encontrado.";
    }

    // Método para atualizar as informações de um médico pelo CRM
    public String atualizarMedico(int crm, String nome, String especialidade, String email, String telefone) {
        // Percorre a lista de médicos para encontrar o médico com o CRM informado
        for (Medico medico : medicos) {
            if (medico.getCrm() == crm) {
                // Atualiza os campos fornecidos, se não forem nulos ou vazios
                if (nome != null && !nome.isEmpty()) {
                    medico.setNome(nome);
                }

                if (especialidade != null && !especialidade.isEmpty()) {
                    medico.setEspecialidade(especialidade);
                }

                if (email != null && !email.isEmpty() && isValidEmail(email)) {
                    medico.setEmail(email);
                } else if (email != null && !email.isEmpty()) {
                    return "E-mail inválido.";
                }

                if (telefone != null && !telefone.isEmpty() && isValidTelefone(telefone)) {
                    medico.setTelefone(telefone);
                } else if (telefone != null && !telefone.isEmpty()) {
                    return "Telefone inválido.";
                }

                // Retorna uma mensagem de sucesso
                return "Dados do médico atualizados com sucesso!";
            }
        }
        // Caso o CRM não seja encontrado na lista
        return "CRM não encontrado.";
    }

    public Medico buscarMedicoPorCRM(int crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm() == crm) {
                return medico; // Retorna o médico se o CRM for encontrado
            }
        }
        return null; // Retorna null se o médico não for encontrado
    }


}
