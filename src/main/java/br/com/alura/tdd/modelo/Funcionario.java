package br.com.alura.tdd.modelo;

import br.com.alura.tdd.service.ReajusteService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void aumentarSalario(BigDecimal reajuste) {
		// Utilizamos o set scale para definir as casas decimais que vão ter no valor
		this.salario = this.salario.add(reajuste).setScale(2, RoundingMode.HALF_UP);
	}
}
