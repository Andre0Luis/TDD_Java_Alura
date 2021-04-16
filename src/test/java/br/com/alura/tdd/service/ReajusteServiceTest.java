package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    //Colocamos o Test para começar a usar o JUnit
    @Test
    public void reajusteTemqueSerTresPorCentoQuandoAdesejar() {

        ReajusteService service = new ReajusteService();
        // Aqui estou instanciando um funcionario
        Funcionario funcionario1 = new Funcionario("Andre", LocalDate.now(), new BigDecimal(1000));
        //Aqui fiz o reajuste         |        Criação de um enum, para eu colocar as outras opções de reajuste
        service.concederReajuste(funcionario1, Desempenho.A_DESEJAR);
        // O AsseerEqual para fazer minha validação que vai ser igual ao salario
        assertEquals(new BigDecimal("1030.00"), funcionario1.getSalario());
    }

    @Test
    public void reajusteTemqueSerQuinzePorCentoQuandoBom() {

        ReajusteService service = new ReajusteService();
        Funcionario funcionario1 = new Funcionario("Andre", LocalDate.now(), new BigDecimal(1000));
        service.concederReajuste(funcionario1, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario1.getSalario());
    }

    @Test
    public void reajusteTemqueSerVintePorCentoQuandoOtimo() {

        ReajusteService service = new ReajusteService();
        Funcionario funcionario1 = new Funcionario("Andre", LocalDate.now(), new BigDecimal(1000));
        service.concederReajuste(funcionario1, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario1.getSalario());
    }
}
