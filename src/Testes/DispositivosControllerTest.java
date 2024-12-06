package Testes;

import Controller.DispositivosController;
import Model.Dispositivos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispositivosControllerTest {
    private Dispositivos dispositivos = new Dispositivos();
    private DispositivosController dispositivosController = new DispositivosController();

    @BeforeEach
    void setUp() {
        dispositivos.setTipo("Termometro");
        dispositivos.setMarca("LG");
        dispositivos.setModelo("TM1");
        dispositivos.setValoresReferencia("12 graus");


    }

    @Test
    void cadastrarDispositivoSucesso() {
        String resultado = dispositivosController.cadastrarDispositivo(dispositivos);
        assertEquals(resultado, "Modelo de dispositivo já cadastrado.");
    }

    @Test
    void cadastrarDispositivoDuplicado() {
        dispositivosController.cadastrarDispositivo(dispositivos);
        String resultado = dispositivosController.cadastrarDispositivo(dispositivos);
        assertEquals(resultado, "Modelo de dispositivo já cadastrado.");

    }

    @Test
    void cadastrarDispositivoFalhado() {
        dispositivos = new Dispositivos();
        String resultado = dispositivosController.cadastrarDispositivo(dispositivos);
        assertEquals(resultado, "Tipo do dispositivo é obrigatório.");
    }

    @Test
    void removerDispositivoSucesso() {
        dispositivosController.cadastrarDispositivo(dispositivos);
        String resultado = dispositivosController.removerDispositivo(dispositivos.getModelo());
        assertEquals(resultado, "Dispositivo removido com sucesso!");

    }

    @Test
    void removerDispositivoFalhado() {
        dispositivos = new Dispositivos();
        String resultado = dispositivosController.removerDispositivo(dispositivos.getModelo());
        assertEquals(resultado,"Dispositivo não encontrado.");
    }

    @Test
    void buscarDispoPorModeloSucesso() {
        dispositivosController.cadastrarDispositivo(dispositivos);
        Dispositivos resultado = dispositivosController.buscarDispoPorModelo("TM1");
        assertEquals(resultado.getModelo(),dispositivos.getModelo());

    }
    @Test
    void buscarDispoPorModeloFalhado() {
        dispositivosController.cadastrarDispositivo(dispositivos);
        Dispositivos resultado = dispositivosController.buscarDispoPorModelo("TM33");
        assertNull(resultado);

    }
}