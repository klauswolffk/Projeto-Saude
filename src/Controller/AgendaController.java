package Controller;

import Model.Agenda;
import Model.Medicacoes;
import Model.Medico;
import Model.Paciente;

import java.util.ArrayList;

public class AgendaController {

    private ArrayList<Agenda> agendas = new ArrayList();

    public String realizarAgendamento(Agenda agenda, Paciente cpf, Medico crm, Medicacoes idMedicacao){
        Medico medAgenda = MedicoController.buscarMedicoPorCRM(crm.getCrm());
        Paciente pacAgenda = PacienteController.buscarPacientePorCPF(cpf.getCpf());
        Medicacoes idAgenda = MedicacoesController.buscarMedicacoesPorId(idMedicacao.getId());
        if (medAgenda != null && pacAgenda != null && idAgenda != null){
            if (agenda.getData() == null || agenda.getData().isEmpty()){
                return "Data é obrigatória.";
            }
            if (agenda.getHora() == null || agenda.getHora().isEmpty()){
                return "Hora é obrigatória.";
            }
            if (agenda.getDiagnostico() == null || agenda.getDiagnostico().isEmpty()){
                return "Diagnóstico é obrigatório.";
            }
            agenda.setMedico(medAgenda);
            agenda.setPaciente(pacAgenda);
            agenda.getPaciente().setMedicacoes(idAgenda);
            agendas.add(agenda);
            return "Agendamento efetuado com sucesso!";
        } else {
            return "Verifique se o Médico, Paciente e Medicamento estão cadastrados";
        }
    }

    public ArrayList<Agenda> listarAgenda() {
        return this.agendas;
    }





}
