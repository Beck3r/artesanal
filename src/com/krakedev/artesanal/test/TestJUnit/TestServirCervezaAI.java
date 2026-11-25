package com.krakedev.artesanal.test.TestJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
	// Tolerancia para comparar valores double
	private static final double DELTA = 0.0001;

	@Test
	public void testServirCervezaCantidadDisponible() {
		// Valida que se pueda servir cerveza cuando existe
		// suficiente cantidad y que se descuente correctamente.
		Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 10000, 5000, "01");

		double resultado = maquina.servirCerveza(1000);

		assertEquals(50.0, resultado, DELTA);
		assertEquals(4000.0, maquina.getCapacidadActual(), DELTA);
	}

	@Test
	public void testServirTodaLaCervezaDisponible() {
		// Valida que se pueda servir exactamente toda la
		// cerveza disponible y que la cantidad restante sea cero.
		Maquina maquina = new Maquina("Club", "Cerveza especial", 0.04, 10000, 2000, "02");

		double resultado = maquina.servirCerveza(2000);

		assertEquals(80.0, resultado, DELTA);
		assertEquals(0.0, maquina.getCapacidadActual(), DELTA);
	}

	@Test
	public void testServirCervezaSinCantidadSuficiente() {
		// Valida que no se sirva cerveza cuando la cantidad
		// solicitada supera la cantidad disponible.
		Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 10000, 500,"03");

		double resultado = maquina.servirCerveza(1000);

		assertEquals(0.0, resultado, DELTA);
		assertEquals(500.0, maquina.getCapacidadActual(), DELTA);
	}

	@Test
	public void testServirCervezaSinExistencias() {
		// Valida que una máquina sin cerveza no pueda servir
		// ninguna cantidad y que permanezca sin existencias.
		Maquina maquina = new Maquina("Club", "Cerveza especial", 0.04, 10000,"04");

		double resultado = maquina.servirCerveza(500);

		assertEquals(0.0, resultado, DELTA);
		assertEquals(0.0, maquina.getCapacidadActual(), DELTA);
	}

	@Test
	public void testServirCeroMililitros() {
		// Valida que solicitar cero mililitros no genere
		// ningún cobro ni modifique las existencias.
		Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 10000, 3000,"05");

		double resultado = maquina.servirCerveza(0);

		assertEquals(0.0, resultado, DELTA);
		assertEquals(3000.0, maquina.getCapacidadActual(), DELTA);
	}

	@Test
	public void testServirCervezaConPrecioDecimal() {
		// Valida que el importe se calcule correctamente
		// cuando el precio por mililitro tiene decimales.
		Maquina maquina = new Maquina("Artesanal", "Cerveza roja", 0.035, 10000, 2000,"06");

		double resultado = maquina.servirCerveza(500);

		assertEquals(17.5, resultado, DELTA);
		assertEquals(1500.0, maquina.getCapacidadActual(), DELTA);
	}

	@Test
	public void testConstructorConCapacidadPredeterminada() {
		// Valida el funcionamiento utilizando el constructor
		// que establece una capacidad máxima de 10000 ml
		// y una cantidad inicial de cero.
		Maquina maquina = new Maquina("Artesanal", "Cerveza artesanal", 0.05,"07");

		double resultado = maquina.servirCerveza(100);

		assertEquals(0.0, resultado, DELTA);
		assertEquals(0.0, maquina.getCapacidadActual(), DELTA);
	}
}
