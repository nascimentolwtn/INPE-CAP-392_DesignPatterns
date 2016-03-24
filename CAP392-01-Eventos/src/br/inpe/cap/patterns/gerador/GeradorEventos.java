package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.EventoMediator;
import br.inpe.cap.patterns.domain.Evento;

public interface GeradorEventos {
	
	Evento gerarEvento(String string);
	
	long doTimer();

	void setStringDoEvento(String string);

	void setEventoMediator(EventoMediator eventoMediator);
	
}
