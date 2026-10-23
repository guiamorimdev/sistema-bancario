package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaPoupancaTest {

    @Test
    public void deveIniciarComSaldoDeCinquentaReais() {
        ContaPoupanca poupanca = new ContaPoupanca("Guilherme");

        assertEquals(50.0, poupanca.getSaldo(), 0.001);
    }

    @Test
    public void deveAplicarJurosAposTrintaDias() {
        ContaPoupanca poupanca = new ContaPoupanca("Guilherme"); // Saldo inicial: 50.0

        poupanca.simularUltimoDia();

        poupanca.renderJuros();

        assertEquals(52.50, poupanca.getSaldo(), 0.001);
    }
}