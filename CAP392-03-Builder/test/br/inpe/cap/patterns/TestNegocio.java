package br.inpe.cap.patterns;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestNegocio {

   Negocio negocio;
   Negocio negocioSub1;
   Negocio negocioSub2;

   @Before
   public void setUp(){
	   this.negocio = new Negocio();
       this.negocioSub1 = new NegocioSub1();
       this.negocioSub2 = new NegocioSub2();
   }

   @Test
   public void testItemA() {
       assertEquals("a) Crie a classe Negocio, que retorna uma String com a palavra \"negocio\".",
    		  		"negocio", negocio.executar());
   }

   @Test
   public void testItemB() {
	   // "b) Chame no final do método executar(), um hook método. Crie duas subclasses que adicionam as palavras “sub1” e “sub2” no retorno desse método."
       assertEquals("negociosub1", negocioSub1.executar());
       assertEquals("negociosub2", negocioSub2.executar());
   }

}
