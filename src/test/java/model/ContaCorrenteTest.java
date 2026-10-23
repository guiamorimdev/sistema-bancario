package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaCorrenteTest {

    @Test
    public void deveDepositarComSucesso() {
        ContaCorrente conta = new ContaCorrente("Guilherme");

        conta.depositar(100.0);

        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    public void deveSacarComSucesso() {
        Conta conta = new ContaCorrente("Guilherme");
        conta.depositar(200.0);

        conta.sacar(50.0);
        assertEquals(150.0, conta.getSaldo(), 0.001);

    }

    @Test
    public void naoDevePermitirDepositarValorNegativoOuZero() {
        ContaCorrente conta = new ContaCorrente("Guilherme");

        assertThrows(exception.ValorInvalidoException.class, () -> {
            conta.depositar(-50.0);
        });
    }

    @Test
    public void naoDevePermitirSacarComSaldoInsuficiente() {
        ContaCorrente conta = new ContaCorrente("Guilherme");
        conta.depositar(100.0);

        assertThrows(exception.SaldoInsuficienteException.class, () -> {
            conta.sacar(150.0);
        });
    }

    @Test
    public void deveTransferirComSucesso() {
        ContaCorrente origem = new ContaCorrente("Guilherme");
        origem.depositar(200.0);

        ContaCorrente destino = new ContaCorrente("Yanne");

        origem.transferir(50.0, destino);

        assertEquals(150.0, origem.getSaldo(), 0.001);
        assertEquals(50.0, destino.getSaldo(), 0.001);
    }

    @Test
    public void deveRegistrarTransacaoNoHIstoricoAposDepositoESaque(){
        ContaCorrente conta = new ContaCorrente("Guilherme");

        conta.depositar(100.0);
        conta.sacar(30);

        assertEquals(2, conta.getHistorico().size());
    }
}