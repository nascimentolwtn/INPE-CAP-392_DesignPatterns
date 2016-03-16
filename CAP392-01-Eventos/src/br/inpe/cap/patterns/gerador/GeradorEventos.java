package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.domain.Evento;

public interface GeradorEventos {
	
	void gerarEventos();
	
	Evento gerarEvento(String string);
	
	long doTimer();

	void setString(String string);
	
}
