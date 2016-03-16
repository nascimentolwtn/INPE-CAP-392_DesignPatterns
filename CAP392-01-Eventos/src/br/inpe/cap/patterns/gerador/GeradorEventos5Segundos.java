package br.inpe.cap.patterns.gerador;

public class GeradorEventos5Segundos extends GeradorEventosAbstrato {
	
	public GeradorEventos5Segundos() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventos5Segundo();
	}

}
