package Controller;


import Model.Dispositivos;
import Model.Paciente;
import View.*;

public class MenuController {
    private PacienteView pacienteView = new PacienteView();
    private MedicoView medicoview = new MedicoView();
    private DispositivoView dispositivoView = new DispositivoView();
    private MedicacoesView medicacoesView = new MedicacoesView();
    private AgendaView agendaView = new AgendaView();
    private MonitoramentoView monitoramentoView = new MonitoramentoView();
    private AlertaView alertaView = new AlertaView();
    public void principalcontroller(byte opcao) {
        Dispositivos dispositivos = new Dispositivos();
        Paciente paciente = new Paciente();
        switch (opcao){
            case 1:
                medicoview.cadastrarMedico();
                break;
            case 2:
                medicoview.listarMedico();
                break;
            case 3:
                medicoview.removerMedico();
                break;
            case 4:
                medicoview.atualizarMedico();
                break;
            case 5:
                dispositivoView.cadastrarDispositivo(dispositivos);
                break;
            case 6:
                dispositivoView.listarDispositivos();
                break;
            case 7:
                dispositivoView.removerDispositivo();
                break;
            case 8:
                pacienteView.cadastrarPaciente(paciente);
                break;
            case 9:
                pacienteView.alterarPaciente();
                break;
            case 10:
                pacienteView.listarPaciente();
                break;
            case 11:
                medicacoesView.cadastrarMedicacao();
                break;
            case 12:
                medicacoesView.alterarDosagem();
                break;
            case 13:
                medicacoesView.removerMedicacao();
                break;
            case 14:
                medicacoesView.listarMedicacoes();
                break;
            case 15:
                agendaView.agendarConsulta();
                break;
            case 16:
                agendaView.listarAgenda();
                break;
            case 17:
                monitoramentoView.cadastrarMonitoramento();
                break;
            case 18:
                monitoramentoView.listarMonitoramentos();
                break;
            case 19:
                alertaView.cadastrarAlerta();
                break;
            case 20:
                alertaView.removerAlerta();
                break;
            case 21:
                alertaView.listarAlertas();
                break;
        }
    }
}
