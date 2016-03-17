package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.domain.EventoMomentoGeracao;

public class GeradorEventosAleatorio extends GeradorEventosThread {

	public GeradorEventosAleatorio() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventosAleatorio();
	}
	
	@Override
	public Evento gerarEvento(String string) {
		return new EventoMomentoGeracao(string, System.currentTimeMillis());
	}
	
}
