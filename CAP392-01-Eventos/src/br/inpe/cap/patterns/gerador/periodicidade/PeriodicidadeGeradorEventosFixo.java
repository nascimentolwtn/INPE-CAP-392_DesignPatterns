package br.inpe.cap.patterns.gerador.periodicidade;

public class PeriodicidadeGeradorEventosFixo implements PeriodicidadeGeradorEventos {

	@Override
	public long getPeriodicidade() {
		return 5 * 1000;
	}

}
