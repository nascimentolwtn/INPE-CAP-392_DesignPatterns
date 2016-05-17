package br.inpe.cap.patterns;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestNegocio {
	
	private Negocio negocio;

	@Before
	public void setUp(){
		negocio = new NegocioBasico();
	}
	
	/**
	 * a) Crie a classe Negocio, que retorna uma String com a palavra "negocio"
	 */
	@Test
	public void testItemA() {
		assertEquals("negocio", negocio.executar());
	}

	/**
	 * b) Chame no final do método executar(), um hook método. Crie duas subclasses que
	 *    adicionam as palavras “sub1” e “sub2” no retorno desse método."
	 */
	@Test
	public void testItemB() {
		negocio = new NegocioSub1();
		assertEquals("negociosub1", negocio.executar());

		negocio = new NegocioSub2();
		assertEquals("negociosub2", negocio.executar());
	}

	/**
	 * c) Crie um Strategy com duas subclasses que adicionam respectivamente “Strat1” e
	 * “Strat2” na String retornada. Crie um Composite que permita que os dois possam ser
	 * configurados. 
	 */
	@Test
	public void testItemC() {
		negocio.setStrategy(NegocioStrategy.STRAT1);
		assertEquals("negocioStrat1", negocio.executar());
		
		negocio.setStrategy(NegocioStrategy.STRAT2);
		assertEquals("negocioStrat2", negocio.executar());

		negocio.setStrategy(NegocioStrategy.NULL_STRATEGY);
		assertEquals("negocio", negocio.executar());
	}

	@Test
	public void testItemCmaisConjuntoComSubClasse1e2() {
		negocio = new NegocioSub1();
		negocio.setStrategy(NegocioStrategy.STRAT1);
		assertEquals("negociosub1Strat1", negocio.executar());
		
		negocio.setStrategy(NegocioStrategy.STRAT2);
		assertEquals("negociosub1Strat2", negocio.executar());
		
		negocio = new NegocioSub2();
		negocio.setStrategy(NegocioStrategy.STRAT1);
		assertEquals("negociosub2Strat1", negocio.executar());

		negocio.setStrategy(NegocioStrategy.STRAT2);
		assertEquals("negociosub2Strat2", negocio.executar());
	}
	
	/**
	 * d) Crie um proxy que pode ser adicionado nessa classe que adiciona “proxy” no retorno.
	 */
	@Test
	public void testItemD() {
		Negocio negocioProxy = new NegocioProxy(negocio);
		assertEquals("negocioproxy", negocioProxy.executar());
	}
	
	/**
	 * e) Crie um Builder com interface fluente que encapsula a criação dessa estrutura. Crie
	 * testes de unidade que verificam, pela String retornada, se a estrutura criada está correta.
	 */
	@Test
	public void testItemE(){
		negocio = new NegocioBuilder().gerarNegocio().construir();
		assertEquals("negocio", negocio.executar());
		
		negocio = new NegocioBuilder().gerarNegocio().comSulfixoSub1().construir();
		assertEquals("negociosub1", negocio.executar());
		
		negocio = new NegocioBuilder().gerarNegocio().comSulfixoSub2().construir();
		assertEquals("negociosub2", negocio.executar());
		
		negocio = new NegocioBuilder().gerarNegocio().comSulfixoStrategy(NegocioStrategy.STRAT1).construir();
		assertEquals("negocioStrat1", negocio.executar());
		
		negocio = new NegocioBuilder().gerarNegocio().comSulfixoStrategy(NegocioStrategy.STRAT2).construir();
		assertEquals("negocioStrat2", negocio.executar());

		negocio = new NegocioBuilder().gerarNegocio().comoProxy().construir();
		assertEquals("negocioproxy", negocio.executar());

		negocio = new NegocioBuilder().gerarNegocio().comSulfixoStrategy(NegocioStrategy.STRAT1).comoProxy().construir();
		assertEquals("negocioStrat1proxy", negocio.executar());
	}
	
	@Test
	public void testQuebrandoObjetoConstruidoPelaInterfaceFluenteBuilder() {
		negocio = new NegocioBuilder().gerarNegocio().comSulfixoStrategy(NegocioStrategy.STRAT1).comoProxy().comSulfixoStrategy(NegocioStrategy.STRAT2).construir();
		assertEquals("negocioStrat2proxy", negocio.executar());
		
		negocio = new NegocioBuilder().gerarNegocio().comSulfixoStrategy(NegocioStrategy.STRAT1).comoProxy().comSulfixoStrategy(NegocioStrategy.STRAT2).comSulfixoSub1().comoProxy().construir();
		assertEquals("negociosub1proxy", negocio.executar());
		
		negocio = new NegocioBuilder().gerarNegocio().comSulfixoStrategy(NegocioStrategy.STRAT1).comoProxy().comSulfixoStrategy(NegocioStrategy.STRAT2).comSulfixoSub1().comoProxy().comSulfixoStrategy(NegocioStrategy.STRAT1).construir();
		assertEquals("negociosub1Strat1proxy", negocio.executar());
	}

}
