package com.krakedev.artesanal.test.TestJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
	
	@Test
	public void testRecargaExitosa() {
		Maquina rubia = new Maquina("Pilsener", "cerveza", 0.02, 8000, "01");
		boolean resultado = rubia.recargarCerveza(3000);
		
		
		assertTrue(resultado);
		assertEquals(3000, rubia.getCapacidadActual(),0.0001);
	}
	
	@Test
	public void testRecargaFallida() {
		Maquina negra = new Maquina("Pilsener", "cerveza", 0.02, 8000, "02");
		negra.recargarCerveza(5000);
		
		boolean resultado = negra.recargarCerveza(1000);
		
		
		assertTrue(resultado);
		assertEquals(6000, negra.getCapacidadActual(),0.0001);
	}
	
	
	
}
