package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.gerador.periodicidade.PeriodicidadeGeradorEventosFixo;

public class GeradorEventosFixo extends GeradorEventosAbstrato {
	
	public GeradorEventosFixo() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventosFixo();
	}

}
