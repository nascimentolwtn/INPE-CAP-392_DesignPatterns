package br.inpe.cap.patterns.gerador;

public class GeradorEventosListaStrings extends GeradorEventosThread {
	
	public GeradorEventosListaStrings() {
		// GeradorEventosListaString não possui periodicidade, envia apenas 1 vez o novo evento contendo a listaStrings
		this.periodicidadeGeradorEventos = null;
	}
	
}
