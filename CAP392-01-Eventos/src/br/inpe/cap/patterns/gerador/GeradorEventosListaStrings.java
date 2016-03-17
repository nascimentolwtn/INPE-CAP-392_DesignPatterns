package br.inpe.cap.patterns.gerador;

public class GeradorEventosListaStrings extends GeradorEventosThread {
	
	public GeradorEventosListaStrings() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventosAleatorio();
	}
	
}
