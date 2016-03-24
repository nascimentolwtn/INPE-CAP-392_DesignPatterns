package br.inpe.cap.patterns.receptor;

import br.inpe.cap.patterns.EventoMediator;
import br.inpe.cap.patterns.domain.Evento;

public class ReceptorEventosContador implements ReceptorEventos {

	private int contador = 0;
	private EventoMediator eventoMediator;

	public ReceptorEventosContador(EventoMediator eventoMediator) {
		this.eventoMediator = eventoMediator;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	@Override
	public void receberEvento(Evento evento) {
		this.contador++;
		System.out.println("Número de eventos recebidos: " + this.contador);
	}

}
