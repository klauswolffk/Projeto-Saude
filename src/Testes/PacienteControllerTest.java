package Testes;

import Controller.PacienteController;
import Model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteControllerTest {
    private Paciente paciente = new Paciente();
    private PacienteController pacienteController = new PacienteController();

    @BeforeEach
    void setUp() {
        paciente.setNome("Paulo");
        paciente.setCpf("84714565087");
        paciente.setDataNascimento("20/02/2001");
        paciente.setEndereco("Rua lb milk, 150");
        paciente.setTelefone("51994038565");
        paciente.setEmail("Paulo@gmail.com");
        paciente.setHistorico("Dores de cabeça frequente");
    }

    @Test
    void registrarPacienteSucesso() {
        String resultado = pacienteController.registrarPaciente(paciente);
        assertEquals(resultado, "Paciente já cadastrado.");
    }
    @Test
    void registrarPacienteDuplicado() {
        pacienteController.registrarPaciente(paciente);
        String resultado = pacienteController.registrarPaciente(paciente);
        assertEquals(resultado, "Paciente já cadastrado.");
    }

    @Test
    void registrarPacienteFalhado() {
        Paciente paciente = new Paciente();
        String resultado = pacienteController.registrarPaciente(paciente);
        assertEquals(resultado,"Nome do paciente é obrigatório.");

    }

    @Test
    void alterarDadosPacienteSucesso() {
        pacienteController.registrarPaciente(paciente);
        String resultado = pacienteController.alterarDadosPaciente("84714565087", paciente);
        assertEquals(resultado, "Dados do paciente alterados com sucesso!");
    }
    @Test
    void alterarDadosPacienteFalhado() {
        pacienteController.registrarPaciente(paciente);
        String resultado = pacienteController.alterarDadosPaciente("5",paciente);
        assertEquals(resultado,"Paciente não encontrado.");
    }

    @Test
    void buscarPacientePorCPFSucesso() {
        pacienteController.registrarPaciente(paciente);
        Paciente resultado = pacienteController.buscarPacientePorCPF("84714565087");
        assertEquals(resultado.getCpf(),paciente.getCpf());
    }
    @Test
    void buscarPacientePorCPFfalhado() {
        pacienteController.registrarPaciente(paciente);
        Paciente resultado = pacienteController.buscarPacientePorCPF("5");
        assertNull(resultado);

    }
}