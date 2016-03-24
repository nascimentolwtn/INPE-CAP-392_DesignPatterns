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
		
		// Exercício complementar para Atividade 01 - Utilizar o padrão Mediator  
		EventoMediator eventoMediator = new EventoMediator();
		
		// Requisito 1.1 - Gerar eventos a cada 5 segundos
		Enviador enviador5segundos = new Enviador("Evento - requisito 1.1", new GeradorEventosFixo(), eventoMediator);
		
		// Requisito 1.2 - Gerar eventos a cada 5 segundos
		Enviador enviadorAleatorio = new Enviador("Evento - requisito 1.2", new GeradorEventosAleatorio(), eventoMediator);
		
		// Requisito 2.1 - Receber eventos e imprimir informações dos eventos
		ReceptorEventos receptorInformacoes = new ReceptorEventosInformacoes(eventoMediator);
		
		// Requisito 2.2 - Receber eventos e imprimir número de eventos recebidos
		ReceptorEventos receptorContador = new ReceptorEventosContador(eventoMediator);
		
		// Requisito Extra 1 - Gerar eventos Aleatorios, apenas com String
		Enviador enviadorAleatorioApenasComString = new Enviador("Evento - requisito Extra 1", new GeradorEventosAleatorioStrings(), eventoMediator);

		// Requisito Extra 2 - Toda vez que receber um evento com uma String, gera um novo evento
		Enviador enviadorReceptor = new Enviador("Evento - requsito Extra 2", new GeradorEventosListaStrings(), eventoMediator);
//		ReceptorEventos receptorEventosEnviador = new ReceptorEventosEnviador(enviadorReceptor);
		ReceptorEventos receptorEventosEnviadorContador = new ReceptorEventosContador(eventoMediator);

		// Inicia Recepção de eventos
		receptorInformacoes.preparaRecepcaoEventos();
		receptorContador.preparaRecepcaoEventos();
//		receptorEventosEnviador.preparaRecepcaoEventos();
		receptorEventosEnviadorContador.preparaRecepcaoEventos();
		
		// Inicia envios após preparar todos os Receptores
		enviador5segundos.enviarEventos();
		enviadorAleatorio.enviarEventos();
		enviadorAleatorioApenasComString.enviarEventos();
		
	}
	
}