package br.inpe.cap.patterns.domain;

import java.util.List;

public class EventoComListaStrings extends Evento {

	private List<String> listaStrings;

	public EventoComListaStrings(String string) {
		super(string);
	}

	public EventoComListaStrings(List<String> listaStrings) {
		super(listaStrings.toString());
		this.listaStrings = listaStrings;
	}

	public List<String> getListaStrings() {
		return listaStrings;
	}

	public void setListaStrings(List<String> listaStrings) {
		this.listaStrings = listaStrings;
	}
	
}
