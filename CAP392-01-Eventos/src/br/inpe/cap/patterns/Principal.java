package br.inpe.cap.patterns;

import br.inpe.cap.patterns.gerador.GeradorEventosAleatorio;
import br.inpe.cap.patterns.gerador.GeradorEventosAleatorioStrings;
import br.inpe.cap.patterns.gerador.GeradorEventosFixo;
import br.inpe.cap.patterns.gerador.GeradorEventosListaStrings;
import br.inpe.cap.patterns.receptor.ReceptorEventos;
import br.inpe.cap.patterns.receptor.ReceptorEventosContador;
import br.inpe.cap.patterns.receptor.ReceptorEventosEnviador;
import br.inpe.cap.patterns.receptor.ReceptorEventosInformacoes;

public class Principal {
	
	public static void main(String[] args) {
		
		// Requisito 1.1 - Gerar eventos a cada 5 segundos
		Enviador enviador5segundos = new Enviador("Evento - requisito 1.1", new GeradorEventosFixo());
		
		// Requisito 1.2 - Gerar eventos a cada 5 segundos
		Enviador enviadorAleatorio = new Enviador("Evento - requisito 1.2", new GeradorEventosAleatorio());
		
		// Requisito 2.1 - Receber eventos e imprimir informa��es dos eventos
		ReceptorEventos receptorInformacoes = new ReceptorEventosInformacoes();
		
		// Requisito 2.2 - Receber eventos e imprimir n�mero de eventos recebidos
		ReceptorEventos receptorContador = new ReceptorEventosContador();
		
		enviador5segundos.addReceptor(receptorInformacoes);
		enviador5segundos.addReceptor(receptorContador);
		enviadorAleatorio.addReceptor(receptorInformacoes);
		enviadorAleatorio.addReceptor(receptorContador);
		
		// Requisito Extra 1 - Gerar eventos Aleatorios, apenas com String
		Enviador enviadorAleatorioApenasComString = new Enviador("Evento - requisito Extra 1", new GeradorEventosAleatorioStrings());
		enviadorAleatorioApenasComString.addReceptor(receptorInformacoes);
		enviadorAleatorioApenasComString.addReceptor(receptorContador);

		// Requisito Extra 2 - Toda vez que receber um evento com uma String, gera um novo evento
		Enviador enviadorReceptor = new Enviador("Evento - requsito Extra 2", new GeradorEventosListaStrings());
		ReceptorEventos receptorEventosEnviador = new ReceptorEventosEnviador(enviadorReceptor);
		ReceptorEventos receptorEventosEnviadorContador = new ReceptorEventosContador();

		enviador5segundos.addReceptor(receptorEventosEnviador);
		enviadorAleatorio.addReceptor(receptorEventosEnviador);
		enviadorAleatorioApenasComString.addReceptor(receptorEventosEnviador);
		
		enviadorReceptor.addReceptor(receptorInformacoes);
		enviadorReceptor.addReceptor(receptorContador);
		enviadorReceptor.addReceptor(receptorEventosEnviadorContador);

		// Inicia envios ap�s preparar todos os Receptores
		enviador5segundos.enviarEventos();
		enviadorAleatorio.enviarEventos();
		enviadorAleatorioApenasComString.enviarEventos();
		
	}
	
}