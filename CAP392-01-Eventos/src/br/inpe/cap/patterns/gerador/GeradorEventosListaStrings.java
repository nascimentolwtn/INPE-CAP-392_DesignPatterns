package br.inpe.cap.patterns.gerador;

import java.util.ArrayList;
import java.util.List;

import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.domain.EventoComListaStrings;

public class GeradorEventosListaStrings extends GeradorEventosAbstrato {
	
	private List<String> listaStrings;
	
	public GeradorEventosListaStrings() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventosAleatorio();
		this.listaStrings = new ArrayList<String>();
	}
	
	@Override
	public Evento gerarEvento(String string) {
		return new EventoComListaStrings(this.listaStrings);
	}

	public void gerarEvento(List<String> listaStringsRecebidasDosEventos) {
		this.listaStrings = listaStringsRecebidasDosEventos;
		this.gerarEvento(this.listaStrings.toString());
	}

}
