package Testes;

import Controller.*;
import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertaControllerTest {
    Alerta alerta = new Alerta();
    Monitoramento monitoramento = new Monitoramento();
    Medico medico = new Medico();
    Paciente paciente = new Paciente();
    Dispositivos dispositivos = new Dispositivos();

    AlertaController alertaController = new AlertaController();
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

        alerta.setMedico(medico);
        alerta.setPaciente(paciente);
        alerta.setMonitoramento(monitoramento);
        alerta.setTipoAlerta("Emergencia");
        alerta.setMensagem("Temperatura elevada do corpo");
        alerta.setData("22/10/2024");
    }


    @Test
    void cadastrarAlertaSucesso() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        String resultado = alertaController.cadastrarAlerta(alerta,medico,paciente,monitoramento);
        assertEquals(resultado, "Alerta cadastrado com sucesso");

    }

    @Test
    void cadastrarAlertaDuplicado() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        alertaController.cadastrarAlerta(alerta,medico,paciente,monitoramento);
        String resultado = alertaController.cadastrarAlerta(alerta,medico,paciente,monitoramento);
        assertEquals(resultado, "ID do Alerta já está cadastrado.");


    }

    @Test
    void cadastrarAlertaFalhado() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        Dispositivos dispositivos = new Dispositivos();
        monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        String resultado = alertaController.cadastrarAlerta(alerta,medico,paciente,monitoramento);
        assertEquals(resultado, "Verifique se o Médico, Paciente e Monitoramento estão cadastrados");

    }

    @Test
    void removerAlertaSucesso() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        alertaController.cadastrarAlerta(alerta,medico,paciente,monitoramento);
        String resultado = alertaController.removerAlerta(alerta.getIdAlerta());
        assertEquals(resultado, "Alerta removido com sucesso!");



    }

    @Test
    void removerAlertaFalhado() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        dispositivosController.cadastrarDispositivo(dispositivos);
        monitoramentoController.cadastrarMonitoramento(monitoramento,medico,paciente,dispositivos);
        Alerta alerta = new Alerta();
        String resultado = alertaController.removerAlerta(alerta.getIdAlerta());
        assertEquals(resultado, "Alerta não encontrado.");

    }
}