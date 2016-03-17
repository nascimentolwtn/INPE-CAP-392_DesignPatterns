package br.inpe.cap.patterns;

import br.inpe.cap.patterns.gerador.GeradorEventos5Segundos;
import br.inpe.cap.patterns.gerador.GeradorEventosAleatorio;
import br.inpe.cap.patterns.gerador.GeradorEventosAleatorioStrings;
import br.inpe.cap.patterns.gerador.GeradorEventosListaStrings;
import br.inpe.cap.patterns.receptor.ReceptorEventos;
import br.inpe.cap.patterns.receptor.ReceptorEventosContador;
import br.inpe.cap.patterns.receptor.ReceptorEventosEnviador;
import br.inpe.cap.patterns.receptor.ReceptorEventosInformacoes;

public class Principal {
	
	public static void main(String[] args) {
		
		// Requisito 1.1 - Gerar eventos a cada 5 segundos
		Enviador enviador5segundos = new Enviador("Evento - requisito 1.1", new GeradorEventos5Segundos());
		
		// Requisito 1.2 - Gerar eventos a cada 5 segundos
		Enviador enviadorAleatorio = new Enviador("Evento - requisito 1.2", new GeradorEventosAleatorio());
		
		// Requisito 2.1 - Receber eventos e imprimir informações dos eventos
		ReceptorEventos receptorInformacoes = new ReceptorEventosInformacoes();
		
		// Requisito 2.2 - Receber eventos e imprimir número de eventos recebidos
		ReceptorEventos receptorContador = new ReceptorEventosContador();
		
		enviador5segundos.addReceptor(receptorInformacoes);
		enviador5segundos.addReceptor(receptorContador);
		enviador5segundos.enviarEventos();

		enviadorAleatorio.addReceptor(receptorInformacoes);
		enviadorAleatorio.addReceptor(receptorContador);
		enviadorAleatorio.enviarEventos();
		
		// Requisito Extra 1 - Gerar eventos Aleatorios, apenas com String
		Enviador enviadorAleatorioApenasComString = new Enviador("Evento - requisito Extra 1", new GeradorEventosAleatorioStrings());
		enviadorAleatorioApenasComString.addReceptor(receptorInformacoes);
		enviadorAleatorioApenasComString.addReceptor(receptorContador);

		enviadorAleatorioApenasComString.enviarEventos();

		// Requisito Extra 2 - Toda vez que receber um evento com uma String, gera um novo evento
		Enviador enviadorReceptor = new Enviador("Evento - requsito Extra 2", new GeradorEventosListaStrings());
		ReceptorEventos receptorEventosEnviador = new ReceptorEventosEnviador(enviadorReceptor);

		// enviadores já iniciaram o envio de eventos, apenas adiciona o novo receptor a cada um deles
		enviador5segundos.addReceptor(receptorEventosEnviador);
		enviadorAleatorio.addReceptor(receptorEventosEnviador);
		enviadorAleatorioApenasComString.addReceptor(receptorEventosEnviador);
		
		enviadorReceptor.addReceptor(receptorInformacoes);
		enviadorReceptor.enviarEventos();

	}
	
}