package Controller;

import Model.*;

import java.util.ArrayList;

public class MonitoramentoController {

    private static ArrayList<Monitoramento> monitoramentos = new ArrayList<>();

    public String cadastrarMonitoramento(Monitoramento monitoramento, Medico crmMoni, Paciente pacMoni, Dispositivos disposiMoni){
        for (Monitoramento moni : monitoramentos) {
            if (moni.getIdMonitoramento() == monitoramento.getIdMonitoramento()) {
                return "ID do Monitoramento já está cadastrado.";
            }
        }
        Medico medMoni = MedicoController.buscarMedicoPorCRM(crmMoni.getCrm());
        Paciente pacMonit = PacienteController.buscarPacientePorCPF(pacMoni.getCpf());
        Dispositivos dispoMoni = DispositivosController.buscarDispoPorModelo(disposiMoni.getModelo());
        if (medMoni != null && pacMonit != null && dispoMoni != null) {
            if (monitoramento.getDadosmonitoramento() == null || monitoramento.getDadosmonitoramento().isEmpty()){
                return "Dados são obrigatórios.";
            }
            monitoramento.setPaciente(pacMonit);
            monitoramento.setDispositivos(dispoMoni);
            monitoramentos.add(monitoramento);
            return "Monitoramento cadastrado.";
        } else {
            return "Verifique se o Médico, Paciente e o Dispositivo estão cadastrados";

        }
    }

    public static Monitoramento buscarMonitoramentoPorID(int idMonitoramento) {
        for (Monitoramento monitora : monitoramentos) {
            if (monitora.getIdMonitoramento() == idMonitoramento) {
                return monitora;
            }
        }
        return null;
    }


    public ArrayList<Monitoramento> listarMonitoramentos() {
        return this.monitoramentos;
    }

}
