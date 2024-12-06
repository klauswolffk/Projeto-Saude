package Testes;

import Controller.DispositivosController;
import Controller.MedicoController;
import Controller.MonitoramentoController;
import Controller.PacienteController;
import Model.Dispositivos;
import Model.Medico;
import Model.Monitoramento;
import Model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonitoramentoControllerTest {
    Monitoramento monitoramento = new Monitoramento();
    Medico medico = new Medico();
    Paciente paciente = new Paciente();
    Dispositivos dispositivos = new Dispositivos();

    MonitoramentoController monitoramentoController = new MonitoramentoController();
    MedicoController medicoController = new MedicoController();
    PacienteController pacienteController = new PacienteController();
    DispositivosController dispositivosController = new DispositivosController();

    @BeforeEach
    void setUp() {
        medico.setNome("Pedro");
        medico.setEspecialidade("Podologo");
        medico.setCrm("1234");
        medico.setEmail("pedro@gmail.com");
        medico.setTelefone("51999999999");

        paciente.setNome("Paulo");
        paciente.setCpf("84714565087");
        paciente.setDataNascimento("20/02/2001");
        paciente.setEndereco("Rua lb milk, 150");
        paciente.setTelefone("51994038565");
        paciente.setEmail("Paulo@gmail.com");
        paciente.setHistorico("Dores de cabeça frequente");

        dispositivos.setTipo("Termometro");
        dispositivos.setMarca("LG");
        dispositivos.setModelo("TM1");
        dispositivos.setValoresReferencia("12 graus");

        monitoramento.setMedico(medico);
        monitoramento.setIdMonitoramento(1);
        monitoramento.setDispositivos(dispositivos);
        monitoramento.setDadosmonitoramento("30 graus");
        monitoramento.setPaciente(paciente);
    }

    @Test
    void cadastrarMonitoramentoSucesso() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        String resultado = monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        assertEquals(resultado, "Monitoramento cadastrado.");
    }

    @Test
    void cadastrarMonitoramentoDuplicado() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        String resultado = monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        assertEquals(resultado, "ID do Monitoramento já está cadastrado.");

    }

    @Test
    void cadastrarMonitoramentoFalhado() {
        Medico medico = new Medico();
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        String resultado = monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        assertEquals(resultado, "Verifique se o Médico, Paciente e o Dispositivo estão cadastrados");


    }

    @Test
    void buscarMonitoramentoPorIDSucesso() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        Monitoramento resultado = MonitoramentoController.buscarMonitoramentoPorID(monitoramento.getIdMonitoramento());
        assertEquals(resultado.getIdMonitoramento(), monitoramento.getIdMonitoramento());

    }

    @Test
    void buscarMonitoramentoPorIDFalhado() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        Monitoramento monitoramento = new Monitoramento();
        Monitoramento resultado = MonitoramentoController.buscarMonitoramentoPorID(monitoramento.getIdMonitoramento());
        assertNull(resultado);
    }
}