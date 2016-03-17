package br.inpe.cap.patterns.receptor;

import java.util.ArrayList;
import java.util.List;

import br.inpe.cap.patterns.Enviador;
import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.domain.EventoComListaStrings;

public class ReceptorEventosEnviador implements ReceptorEventos {

	private List<String> listaStringsRecebidasDosEventos;
	private Enviador enviador;

	public ReceptorEventosEnviador(Enviador enviador) {
		this.enviador = enviador;
		this.listaStringsRecebidasDosEventos = new ArrayList<String>();
	}

	@Override
	public synchronized void receberEvento(Evento evento) {
		this.listaStringsRecebidasDosEventos.add(evento.getString());
		List<String> copiaListaStringRecebidas = new ArrayList<String>(this.listaStringsRecebidasDosEventos);
		EventoComListaStrings eventoComListaStrings = new EventoComListaStrings(copiaListaStringRecebidas);
		this.enviador.notificaReceptores(eventoComListaStrings);
	}
	
	

}
