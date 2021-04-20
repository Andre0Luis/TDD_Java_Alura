package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

	// Método 1 de fazer a exception
	//	@Test
	//	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
	//		BonusService service = new BonusService();
	//		// Ele está verification se durante essa chamada a exception está acontecendo
	//		assertThrows(IllegalArgumentException.class,
	//				// classe da excepetion que estamos chamando
	//				() ->service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000"))));
	//
	//	}

 // Método 2 de fazer a exception
	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));

		try {
		service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
		fail("Não entrou a excepetion");
		} catch (Exception e) {
			assertEquals("Funcionário com salario superior ao limite de bonus!", e.getMessage());
	}

	}


	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
