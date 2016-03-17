package br.inpe.cap.patterns.gerador;

public class GeradorEventosAleatorioStrings extends GeradorEventosThread {

	public GeradorEventosAleatorioStrings() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventosAleatorio();
	}

}
