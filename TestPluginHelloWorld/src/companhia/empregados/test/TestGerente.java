package companhia.empregados.test;
 
 import junit.framework.TestCase;

import companhia.empregados.Gerente;
 
 public class TestGerente extends TestCase {
 
     public void testSalarioSemProjetos() {
       Gerente gerente = new Gerente();
       gerente.setSoldoBruto(3000.00);
       assertTrue("Soldo menos 25%", gerente.getSoldoLiquido()==2250.00);
       gerente = null;
     }
 
     public void testSalarioProjeto() {
       Gerente gerente = new Gerente();
       gerente.setSoldoBruto(3000.00);
       gerente.adicionaProjeto("Projeto 1");
       assertTrue("Soldo menos 25% mais 200 por projeto",
                 gerente.getSoldoLiquido() == 2450.00);
       gerente = null;
     }
 
     public void testSalarioProjetos() {
       Gerente gerente = new Gerente();
       gerente.setSoldoBruto(3000.00);
       gerente.adicionaProjeto("Projeto 1");
       gerente.adicionaProjeto("Projeto 2");
       assertTrue("Soldo menos 25% mais 200 por projeto",
                 gerente.getSoldoLiquido() == 2650.00);
       gerente = null;
     }
 
     public void testPlanoSaude() {
       Gerente gerente = new Gerente();
       gerente.setSoldoBruto(3000.00);
       gerente.setPlanoSaude(true);
       assertTrue("Soldo menos 25% menos 5%",
                 gerente.getSoldoLiquido()==2100.00);
       gerente = null;
     }
 
}
