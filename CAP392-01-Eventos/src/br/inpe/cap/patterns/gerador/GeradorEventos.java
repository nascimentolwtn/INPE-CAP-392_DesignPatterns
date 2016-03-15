package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.domain.Evento;

public interface GeradorEventos {
	
	Evento gerarEvento(String string);
	
	long doTimer();
	
}
