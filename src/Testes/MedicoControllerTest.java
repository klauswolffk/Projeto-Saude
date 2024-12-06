package Testes;

import Controller.MedicoController;
import Model.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicoControllerTest {
    private Medico medico = new Medico();
    private MedicoController medicoController = new MedicoController();

    @BeforeEach
    void setUp() {
        medico.setNome("Pedro");
        medico.setEspecialidade("Podologo");
        medico.setCrm("1234");
        medico.setEmail("pedro@gmail.com");
        medico.setTelefone("51999999999");
    }

    @Test
    void registrarmedicoSucesso() {
        String resultado = medicoController.registrarmedico(medico);
        assertEquals(resultado, "Médico cadastrado com sucesso!");
    }
    @Test
    void registrarmedicoCRMduplicado() {
        medicoController.registrarmedico(medico);
        String resultado = medicoController.registrarmedico(medico);
        assertEquals(resultado,"CRM já está cadastrado.");
    }
    @Test
    void registrarMedicoFalhado() {
        medico = new Medico();
        String resultado = medicoController.registrarmedico(medico);
        assertEquals(resultado,"Nome do médico é obrigatório.");

    }


    @Test
    void removerMedicoSucesso() {
        medicoController.registrarmedico(medico);
        String resultado = medicoController.removerMedico(medico.getCrm());
        assertEquals(resultado,"Médico removido com sucesso!");
    }
    @Test
    void removerMedicoFalhado() {
        medico = new Medico();
        String resultado = medicoController.removerMedico(medico.getCrm());
        assertEquals(resultado,"CRM não encontrado.");
    }

    @Test
    void atualizarMedicoSucesso() {
        medicoController.registrarmedico(medico);
        String resultado = medicoController.atualizarMedico("1234", "Joao", "", "", "");
        assertEquals(resultado,"Dados do médico atualizados com sucesso!");
    }
    @Test
    void atualizarMedicoFalhado() {
        medico = new Medico();
        String resultado = medicoController.atualizarMedico("", "Joao", "", "", "");
        assertEquals(resultado,"CRM não encontrado.");
    }

    @Test
    void buscarMedicoPorCRMSucesso() {
        medicoController.registrarmedico(medico);
        Medico resultado = medicoController.buscarMedicoPorCRM("1234");
        assertEquals(resultado.getCrm(),medico.getCrm());

    }
    @Test
    void buscarMedicoPorCRMFalhado() {
        medicoController.registrarmedico(medico);
        Medico resultado = medicoController.buscarMedicoPorCRM("123544");
        assertNull(resultado);
    }
}