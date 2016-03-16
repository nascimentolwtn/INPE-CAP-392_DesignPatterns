package br.inpe.cap.patterns.receptor;

import br.inpe.cap.patterns.domain.Evento;

public class ReceptorEventosInformacoes implements ReceptorEventos {
	
	@Override
	public void receberEvento(Evento evento) {
		System.out.println(evento.print());
	}

	@Override
	public void receberEventos() {
		// TODO Auto-generated method stub
		
	}

}
