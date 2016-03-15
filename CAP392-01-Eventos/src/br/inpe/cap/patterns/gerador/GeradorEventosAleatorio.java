package br.inpe.cap.patterns.gerador;

import java.util.Random;

import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.domain.EventoMomentoGeracao;

public class GeradorEventosAleatorio extends GeradorEventosAbstrato {

	private static final Random RANDOM = new Random(System.currentTimeMillis());

	@Override
	public long doTimer() {
		return RANDOM.nextInt(10) + 1;
	}
	
	@Override
	public Evento gerarEvento(String string) {
		return new EventoMomentoGeracao(string, System.currentTimeMillis());
	}
	
}
