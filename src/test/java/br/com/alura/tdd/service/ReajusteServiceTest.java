package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void iniciar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Andre", LocalDate.now(), new BigDecimal(1000));
    }

    //Colocamos o Test para começar a usar o JUnit
    @Test
    public void reajusteTemqueSerTresPorCentoQuandoAdesejar() {
        //Aqui fiz o reajuste         |        Criação de um enum, para eu colocar as outras opções de reajuste
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        // O AsseerEqual para fazer minha validação que vai ser igual ao salario
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteTemqueSerQuinzePorCentoQuandoBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteTemqueSerVintePorCentoQuandoOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
