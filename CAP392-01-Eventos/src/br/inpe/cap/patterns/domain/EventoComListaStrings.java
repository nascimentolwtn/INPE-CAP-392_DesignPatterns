package br.inpe.cap.patterns.domain;

import java.util.List;

public class EventoComListaStrings extends Evento {

	private List<String> listaStrings;

	private EventoComListaStrings(String string) {
		super(string);
	}

	public EventoComListaStrings(List<String> listaStrings) {
		super(listaStrings.toString());
		this.listaStrings = listaStrings;
	}
	
}
