package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.gerador.periodicidade.PeriodicidadeGeradorEventosAleatorio;

public class GeradorEventosAleatorioStrings extends GeradorEventosAbstrato {

	public GeradorEventosAleatorioStrings() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventosAleatorio();
	}

}
