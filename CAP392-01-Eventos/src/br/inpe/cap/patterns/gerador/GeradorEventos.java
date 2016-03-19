package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.Enviador;
import br.inpe.cap.patterns.domain.Evento;

public interface GeradorEventos {
	
	void iniciarGeracaoEventos();
	
	Evento gerarEvento(String string);
	
	long doTimer();

	void setStringDoEvento(String string);

	void setEnviador(Enviador enviador);
	
}
