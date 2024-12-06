package Controller;

import Model.Medicacoes;
import Model.Medico;
import java.util.ArrayList;

public class MedicacoesController {

    private static ArrayList<Medicacoes> medicacoes = new ArrayList<>();

    // Método para cadastrar medicação
    public String cadastrarMedicacao(Medicacoes medicacao, Medico crm) {
        // Validação de ID único
        for (Medicacoes m : medicacoes) {
            if (m.getId() == medicacao.getId()) {
                return "ID da medicação já está cadastrado.";
            }
        }
        Medico medOld = MedicoController.buscarMedicoPorCRM(crm.getCrm());
        if(medOld != null){
            if (medicacao.getNome() == null || medicacao.getNome().isEmpty()) {
                return "Nome da medicação é obrigatório.";
            }
            if (medicacao.getDosagem() == null || medicacao.getDosagem().isEmpty()) {
                return "Dosagem da medicação é obrigatória.";
            }
            if (medicacao.getFrequencia() == null || medicacao.getFrequencia().isEmpty()) {
                return "Frequência da medicação é obrigatória.";
            }
            if (medicacao.getDescricao() == null || medicacao.getDescricao().isEmpty()) {
                return "Descrição da medicação é obrigatória.";
            }
            if (medicacao.getDataPrescricao() == null || medicacao.getDataPrescricao().isEmpty()) {
                return "Data da prescrição é obrigatória.";
            }
            // Adicionando medicação à lista
            medicacao.setMedico(medOld);
            medicacoes.add(medicacao);
            return "Medicação registrada com sucesso!";
        }else{
            return "CRM do médico não encontrado";
        }
    }

    // Método para remover medicação pelo ID
    public String removerMedicacaoPorId(int id) {
        for (Medicacoes medicacao : medicacoes) {
            if (medicacao.getId() == id) {
                medicacoes.remove(medicacao);
                return "Medicação removida com sucesso!";
            }
        }
        return "Medicação com o ID fornecido não encontrada.";
    }

    // Método para alterar a dosagem de uma medicação
    public String alterarDosagem(String id, String novaDosagem) {
        for (Medicacoes medicacao : medicacoes) {
            if (medicacao.getId() == Integer.parseInt(id)) {
                medicacao.setDosagem(novaDosagem);
                return "Dosagem da medicação atualizada com sucesso!";
            }
        }
        return "Medicação não encontrada.";
    }

    // Método para listar todas as medicações cadastradas
    public ArrayList<Medicacoes> listarMedicacoes() {
        return this.medicacoes;
    }

    public static Medicacoes buscarMedicacoesPorId(int id) {
        for (Medicacoes medicacao : medicacoes) {
            if (medicacao.getId() == id) {
                return medicacao;
            }
        }
        return null;
    }

}
