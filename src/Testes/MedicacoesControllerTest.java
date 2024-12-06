package Testes;

import Controller.MedicacoesController;
import Controller.MedicoController;
import Model.Medicacoes;
import Model.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicacoesControllerTest {
    private Medicacoes medicacoes = new Medicacoes();
    private MedicacoesController medicacoesController = new MedicacoesController();
    private Medico medico = new Medico();
    private MedicoController medicoController = new MedicoController();

    @BeforeEach
    void setUp() {
        medico.setNome("Pedro");
        medico.setEspecialidade("Podologo");
        medico.setCrm("1234");
        medico.setEmail("pedro@gmail.com");
        medico.setTelefone("51999999999");
        medicacoes.setMedico(medico);
        medicacoes.setId(1);
        medicacoes.setNome("Paracetamol");
        medicacoes.setDosagem("1 comprimido");
        medicacoes.setFrequencia("A cada 12 horas");
        medicacoes.setDescricao("Uso continuo para melhorar a dor de cabeça.");
        medicacoes.setDataPrescricao("22/12/2024");
    }

    @Test
    void cadastrarMedicacaoSucesso() {
        medicoController.registrarmedico(medico);
        String resultado = medicacoesController.cadastrarMedicacao(medicacoes,medico);
        assertEquals(resultado, "Medicação registrada com sucesso!");

    }

    @Test
    void cadastrarMedicacaoDuplicado() {
        medicoController.registrarmedico(medico);
        medicacoesController.cadastrarMedicacao(medicacoes,medico);
        String resultado = medicacoesController.cadastrarMedicacao(medicacoes,medico);
        assertEquals(resultado, "ID da medicação já está cadastrado.");

    }

    @Test
    void cadastrarMedicacaoFalhado() {
        String resultado = medicacoesController.cadastrarMedicacao(medicacoes,medico);
        assertEquals(resultado, "CRM do médico não encontrado");

    }

    @Test
    void removerMedicacaoPorIdSucesso() {
        medicoController.registrarmedico(medico);
        medicacoesController.cadastrarMedicacao(medicacoes,medico);
        String resultado = medicacoesController.removerMedicacaoPorId(medicacoes.getId());
        assertEquals(resultado,"Medicação removida com sucesso!");
    }

    @Test
    void removerMedicacaoPorIdFalhado() {
        medicoController.registrarmedico(medico);
        Medicacoes medicacoes = new Medicacoes();
        String resultado = medicacoesController.removerMedicacaoPorId(medicacoes.getId());
        assertEquals(resultado,"Medicação com o ID fornecido não encontrada.");

    }

    @Test
    void alterarDosagemSucesso() {
        medicoController.registrarmedico(medico);
        medicacoesController.cadastrarMedicacao(medicacoes,medico);
        String resultado = medicacoesController.alterarDosagem(String.valueOf(1),"50ml");
        assertEquals(resultado,"Dosagem da medicação atualizada com sucesso!");

    }

    @Test
    void alterarDosagemFalhado() {
        medicoController.registrarmedico(medico);
        Medicacoes medicacoes = new Medicacoes();
        String resultado = medicacoesController.alterarDosagem(String.valueOf(7),"50ml");
        assertEquals(resultado,"Medicação não encontrada.");


    }


    @Test
    void buscarMedicacoesPorIdSucesso() {
        medicoController.registrarmedico(medico);
        medicacoesController.cadastrarMedicacao(medicacoes,medico);
        Medicacoes resultado = medicacoesController.buscarMedicacoesPorId(medicacoes.getId());
        assertEquals(resultado.getId(),medicacoes.getId());

    }

    @Test
    void buscarMedicacoesPorIdFalhado() {
        medicoController.registrarmedico(medico);
        Medicacoes medicacoes = new Medicacoes();
        Medicacoes resultado = medicacoesController.buscarMedicacoesPorId(medicacoes.getId());
        assertNull(resultado);

    }

}