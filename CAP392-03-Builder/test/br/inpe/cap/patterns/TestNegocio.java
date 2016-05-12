package br.inpe.cap.patterns;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestNegocio {

   Negocio negocio;
   
   @Before
   public void setUp(){
	   this.negocio = new Negocio();
   }

   @Test
   public void testItemA() {
      assertEquals("a) Crie a classe Negocio, que retorna uma String com a palavra \"negocio\".",
    		  	   "negocio", negocio.executar());
   }

}
