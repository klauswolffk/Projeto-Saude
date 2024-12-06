package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class AlertaController {

    private ArrayList<Alerta> alertas = new ArrayList<>();

    public String cadastrarAlerta(Alerta alerta, Medico mediAlerta, Paciente paciAlerta, Monitoramento monitorAlerta) {
        for (Alerta alert : alertas) {
            if (alert.getIdAlerta() == alerta.getIdAlerta()) {
                return "ID do Alerta já está cadastrado.";
            }
        }
        Medico medAlerta = MedicoController.buscarMedicoPorCRM(mediAlerta.getCrm());
        Paciente pacAlerta = PacienteController.buscarPacientePorCPF(paciAlerta.getCpf());
        Monitoramento moniAlerta = MonitoramentoController.buscarMonitoramentoPorID(monitorAlerta.getIdMonitoramento());
        if (medAlerta != null && pacAlerta != null && moniAlerta != null){
            if (alerta.getTipoAlerta() == null || alerta.getTipoAlerta().isEmpty()){
                return "Tipo do Alerta é obrigatório.";
            }
            if (alerta.getMensagem() == null || alerta.getMensagem().isEmpty()){
                System.out.println(alerta.getMensagem() + "mensagem teste");
                return "Descrição é obrigatória.";
            }
            if (alerta.getData() == null || alerta.getData().isEmpty()){
                return "Data é obrigatória.";
            }
            alerta.setMedico(medAlerta);
            alerta.setPaciente(pacAlerta);
            alerta.setMonitoramento(moniAlerta);
            alertas.add(alerta);
            return "Alerta cadastrado com sucesso";

        }
        return "Verifique se o Médico, Paciente e Monitoramento estão cadastrados";
    }

    public ArrayList<Alerta> listarAlerta() {
        return this.alertas;
    }

    public String removerAlerta(int idAlerta) {
        Iterator<Alerta> iterator = alertas.iterator();
        while (iterator.hasNext()) {
            Alerta alerta = iterator.next();
            if (alerta.getIdAlerta() == idAlerta) {
                iterator.remove();
                return "Alerta removido com sucesso!";
            }
        }
        return "Alerta não encontrado.";
    }
}
