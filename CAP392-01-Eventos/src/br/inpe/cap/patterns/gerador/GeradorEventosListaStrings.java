package br.inpe.cap.patterns.gerador;

import java.util.ArrayList;
import java.util.List;

public class GeradorEventosListaStrings extends GeradorEventosAbstrato {
	
	private List<String> listaStrings;
	
	public GeradorEventosListaStrings() {
		this.periodicidadeGeradorEventos = new PeriodicidadeGeradorEventosAleatorio();
		this.listaStrings = new ArrayList<String>();
	}
	
}
