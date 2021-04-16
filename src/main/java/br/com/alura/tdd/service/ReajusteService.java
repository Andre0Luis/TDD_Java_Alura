package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    //Aqui foi criada essa classe, somente após fazermos o primeiro teste com o JUnit
    public void concederReajuste(Funcionario funcionario1, Desempenho desempenho) {

            // Aqui está fazendo o calculo                 |||             Aqui a porcentagem de reajuste
            BigDecimal percentual = desempenho.percentualdoReajuste();
            BigDecimal reajuste = funcionario1.getSalario().multiply(percentual);
            funcionario1.aumentarSalario(reajuste);

    }
}
