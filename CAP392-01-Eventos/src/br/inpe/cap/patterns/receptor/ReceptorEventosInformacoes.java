package br.inpe.cap.patterns.receptor;

import br.inpe.cap.patterns.EventoMediator;
import br.inpe.cap.patterns.domain.Evento;

public class ReceptorEventosInformacoes implements ReceptorEventos {
	
	private EventoMediator eventoMediator;

	public ReceptorEventosInformacoes(EventoMediator eventoMediator) {
		this.eventoMediator = eventoMediator;
	}

	@Override
	public void receberEvento(Evento evento) {
		System.out.println(evento.print());
	}

}
