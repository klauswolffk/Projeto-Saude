package Testes;

import Controller.AgendaController;
import Controller.MedicacoesController;
import Controller.MedicoController;
import Controller.PacienteController;
import Model.Agenda;
import Model.Medicacoes;
import Model.Medico;
import Model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaControllerTest {
    Agenda agenda = new Agenda();
    Medico medico = new Medico();
    Paciente paciente = new Paciente();
    Medicacoes medicacoes = new Medicacoes();

    AgendaController agendaController = new AgendaController();
    MedicoController medicoController = new MedicoController();
    PacienteController pacienteController = new PacienteController();
    MedicacoesController medicacoesController = new MedicacoesController();


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

        medicacoes.setMedico(medico);
        medicacoes.setId(1);
        medicacoes.setNome("Paracetamol");
        medicacoes.setDosagem("1 comprimido");
        medicacoes.setFrequencia("A cada 12 horas");
        medicacoes.setDescricao("Uso continuo para melhorar a dor de cabeça.");
        medicacoes.setDataPrescricao("22/12/2024");

        agenda.setData("22/04/2024");
        agenda.setHora("15:00");
        agenda.setMedico(medico);
        agenda.setPaciente(paciente);
        agenda.setDiagnostico("Dor de cabeça");
        agenda.setMedicacoes(medicacoes);

    }

    @Test
    void realizarAgendamentoSucesso() {
        medicoController.registrarmedico(medico);
        pacienteController.registrarPaciente(paciente);
        medicacoesController.cadastrarMedicacao(medicacoes,medico);
        String resultado = agendaController.realizarAgendamento(agenda,paciente,medico,medicacoes);
        assertEquals(resultado,"Agendamento efetuado com sucesso!");

    }

    @Test
    void realizarAgendamentoFalhado() {
        medicoController.registrarmedico(medico);
        Paciente paciente = new Paciente();
        medicacoesController.cadastrarMedicacao(medicacoes,medico);
        String resultado = agendaController.realizarAgendamento(agenda,paciente,medico,medicacoes);
        assertEquals(resultado,"Verifique se o Médico, Paciente e Medicamento estão cadastrados");
    }
}