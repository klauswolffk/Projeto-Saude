package Controller;


import Model.Dispositivos;
import Model.Paciente;
import View.DispositivoView;
import View.MedicoView;
import View.PacienteView;

public class MenuController {
    PacienteView pacienteView = new PacienteView();
    MedicoView medicoview = new MedicoView();
    DispositivoView dispositivoView = new DispositivoView();
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
                pacienteView.listarPaciente();
                break;
            case 10:
                break;

        }
    }
}
