package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.gerador.periodicidade.PeriodicidadeGeradorEventos5Segundo;

public class GeradorEventos5Segundos extends GeradorEventosThread {
	
	public GeradorEventos5Segundos() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventos5Segundo();
	}

}
