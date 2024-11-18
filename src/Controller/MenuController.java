package Controller;

import Model.Paciente;
import View.DispositivoView;
import View.MedicoView;
import View.PacienteView;

public class MenuController {
    PacienteView pacienteView = new PacienteView();
    MedicoView medicoview = new MedicoView();
    DispositivoView dispositivoView = new DispositivoView();
    public void principalcontroller(byte opcao) {
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
                dispositivoView.cadastrarDispositivo();
                break;
            case 6:
                dispositivoView.listarDispositivos();
                break;
            case 7:
                dispositivoView.removerDispositivo();
                break;
            case 8:
                pacienteView.cadastrarPaciente();
                break;
            case 9:
                break;
            case 10:
                break;

        }
    }
}
