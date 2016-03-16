package br.inpe.cap.patterns.gerador;

public class PeriodicidadeGeradorEventos5Segundo implements PeriodicidadeGeradorEventos {

	@Override
	public long getPeriodicidade() {
		return 5 * 1000;
	}

}
