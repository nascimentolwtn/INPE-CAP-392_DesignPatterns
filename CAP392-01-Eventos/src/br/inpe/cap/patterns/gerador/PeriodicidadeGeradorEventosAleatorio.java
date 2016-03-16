package br.inpe.cap.patterns.gerador;

import java.util.Random;

public class PeriodicidadeGeradorEventosAleatorio implements PeriodicidadeGeradorEventos {

	private static final Random RANDOM = new Random(System.currentTimeMillis());
	
	@Override
	public long getPeriodicidade() {
		return (RANDOM.nextInt(10) + 1) * 1000;
	}

}
