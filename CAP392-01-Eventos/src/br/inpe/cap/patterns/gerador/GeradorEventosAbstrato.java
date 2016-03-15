package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.domain.Evento;

public abstract class GeradorEventosAbstrato extends Thread implements GeradorEventos {
	
	@Override
	public Evento gerarEvento(String string) {
		return new Evento(string);
	}

}