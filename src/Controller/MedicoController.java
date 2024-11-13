package Controller;

import Model.Medico;

import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicoController {

    private ArrayList<Medico> medicos = new ArrayList();

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
        // 3. Adicionando o médico à lista se todas as validações passarem
        medicos.add(medico);
        return "Médico cadastrado com sucesso!";
    }

    // Validação do formato de e-mail (simples)
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validação do formato do telefone (simples, somente números)
    private boolean isValidTelefone(String telefone) {
        // Aqui você pode adicionar uma validação mais rigorosa dependendo do formato desejado
        return telefone.matches("\\d{10,11}"); // Exemplo: telefone de 10 ou 11 dígitos
    }


    public ArrayList<Medico> listarMedicos() {
        return this.medicos;
    }
}
