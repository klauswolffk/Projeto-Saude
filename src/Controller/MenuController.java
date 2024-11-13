package Controller;

import View.MedicoView;

public class MenuController {
    MedicoView medicoview = new MedicoView();
    public void principalcontroller(byte opcao) {
        switch (opcao){
            case 1:
                medicoview.cadastrarMedico();
                break;
            case 2:
                medicoview.listarMedico();
                break;
        }
    }
}
