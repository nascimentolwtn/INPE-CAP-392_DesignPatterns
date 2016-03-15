package br.inpe.cap.patterns.gerador;

public class GeradorEventos5Segundos extends GeradorEventosAbstrato {

	@Override
	public long doTimer() {
		return 5;
	}

}
