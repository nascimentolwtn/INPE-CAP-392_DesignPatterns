package br.inpe.cap.patterns.receptor;

import java.util.ArrayList;
import java.util.List;

import br.inpe.cap.patterns.EventoMediator;
import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.domain.EventoComListaStrings;

public class ReceptorEventosEnviador implements ReceptorEventos {

	private List<String> listaStringsRecebidasDosEventos;
	private EventoMediator eventoMediator;

	public ReceptorEventosEnviador(EventoMediator eventoMediator) {
		this.eventoMediator = eventoMediator;
		this.listaStringsRecebidasDosEventos = new ArrayList<String>();
	}

	@Override
	public synchronized void receberEvento(Evento evento) {
		this.listaStringsRecebidasDosEventos.add(evento.getString());
		List<String> copiaListaStringRecebidas = new ArrayList<String>(this.listaStringsRecebidasDosEventos);
		EventoComListaStrings eventoComListaStrings = new EventoComListaStrings(copiaListaStringRecebidas);
		this.eventoMediator.notificaEventoProduzido(eventoComListaStrings);
	}
	
	

}
