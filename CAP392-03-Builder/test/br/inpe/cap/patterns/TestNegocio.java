package br.inpe.cap.patterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNegocio {

	@Test
	public void testExecutar() {
		Negocio negocio = new Negocio();
		assertEquals("negocio", negocio.executar());
	}

}
