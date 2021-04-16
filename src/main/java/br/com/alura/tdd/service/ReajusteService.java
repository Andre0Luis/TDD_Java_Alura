package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    //Aqui foi criada essa classe, somente após fazermos o primeiro teste com o JUnit
    public void concederReajuste(Funcionario funcionario1, Desempenho desempenho) {

        // Estou dizendo que o desenpenho tem que ser igual ao enum

        if (desempenho == Desempenho.A_DESEJAR) {
            // Aqui está fazendo o calculo                 |||             Aqui a porcentagem de reajuste
            BigDecimal reajuste = funcionario1.getSalario().multiply(new BigDecimal("0.03"));
            funcionario1.aumentarSalario(reajuste);

        } else if (desempenho == desempenho.BOM) {
            BigDecimal reajuste = funcionario1.getSalario().multiply(new BigDecimal("0.15"));
            funcionario1.aumentarSalario(reajuste);
        } else {
            BigDecimal reajuste = funcionario1.getSalario().multiply(new BigDecimal("0.20"));
            funcionario1.aumentarSalario(reajuste);
        }
    }
}
