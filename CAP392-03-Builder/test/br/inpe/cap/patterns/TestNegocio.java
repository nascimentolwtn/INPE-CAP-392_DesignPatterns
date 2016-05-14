package br.inpe.cap.patterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNegocio {

	/**
	 * a) Crie a classe Negocio, que retorna uma String com a palavra "negocio"
	 */
	@Test
	public void testItemA() {
		Negocio negocio = new NegocioBasico();
		assertEquals("negocio", negocio.executar());
	}

	/**
	 * b) Chame no final do método executar(), um hook método. Crie duas subclasses que
	 *    adicionam as palavras “sub1” e “sub2” no retorno desse método."
	 */
	@Test
	public void testItemB() {
		Negocio negocioSub1 = new NegocioSub1();
		assertEquals("negociosub1", negocioSub1.executar());

		Negocio negocioSub2 = new NegocioSub2();
		assertEquals("negociosub2", negocioSub2.executar());
	}

	/**
	 * c) Crie um Strategy com duas subclasses que adicionam respectivamente “Strat1” e
	 * “Strat2” na String retornada. Crie um Composite que permita que os dois possam ser
	 * configurados. 
	 */
	@Test
	public void testItemC() {
		Negocio negocioSub1Strat1 = new NegocioSub1();
		negocioSub1Strat1.setStrategy(NegocioStrategy.STRAT1);
		
		Negocio negocioSub1Strat2 = new NegocioSub1();
		negocioSub1Strat2.setStrategy(NegocioStrategy.STRAT2);
		
		Negocio negocioSub2Strat1 = new NegocioSub2();
		negocioSub2Strat1.setStrategy(NegocioStrategy.STRAT1);

		Negocio negocioSub2Strat2 = new NegocioSub2();
		negocioSub2Strat2.setStrategy(NegocioStrategy.STRAT2);
		
		assertEquals("negociosub1Strat1", negocioSub1Strat1.executar());
		assertEquals("negociosub1Strat2", negocioSub1Strat2.executar());
		assertEquals("negociosub2Strat1", negocioSub2Strat1.executar());
		assertEquals("negociosub2Strat2", negocioSub2Strat2.executar());
	}
	
	/**
	 * d) Crie um proxy que pode ser adicionado nessa classe que adiciona “proxy” no retorno.
	 */
	@Test
	public void testItemD() {
		Negocio negocioProxy = new NegocioProxy(new NegocioBasico());
		assertEquals("negocioproxy", negocioProxy.executar());
	}

}
