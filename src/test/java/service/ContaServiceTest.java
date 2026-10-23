package service;

import model.ContaCorrente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaServiceTest {

    @Test
    public void deveAdicionarEBuscarContaComSucesso() {
        ContaService service = new ContaService();
        ContaCorrente conta = new ContaCorrente("Guilherme");

        service.adicionarConta(conta);

        var contaEncontrada = service.buscarConta(conta.getNumero());

        assertNotNull(contaEncontrada);
        assertEquals(conta.getCliente(), contaEncontrada.getCliente());
    }

    @Test
    public void deveLancarExcecaoQuandoContaNaoForEncontrada() {
        ContaService service = new ContaService();

        assertThrows(exception.ContaNaoEncontradaException.class, () -> {
            service.buscarConta("9999");
        });
    }
}