package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.gerador.periodicidade.PeriodicidadeGeradorEventos5Segundo;

public class GeradorEventosFixo extends GeradorEventosThread {
	
	public GeradorEventosFixo() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventos5Segundo();
	}

}
