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
   public void testExecutar() {
      assertEquals("negocio", negocio.executar());
   }

}
