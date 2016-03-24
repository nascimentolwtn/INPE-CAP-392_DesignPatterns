package br.inpe.cap.patterns;

import br.inpe.cap.patterns.gerador.GeradorEventos;

public class Enviador {

	private GeradorEventos geradorEventos;
	private String string;
	
	public Enviador(String string, GeradorEventos geradorEventos, EventoMediator eventoMediator) {
		this.string = string;
		this.geradorEventos = geradorEventos;
		this.geradorEventos.setStringDoEvento(string);
		this.geradorEventos.setEventoMediator(eventoMediator);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	public void enviarEventos() {
		
		Thread threadGeradorEventos = new Thread((Runnable) this.geradorEventos);
		threadGeradorEventos.setName("Thread GeradorEventos: " + this.string);
		threadGeradorEventos.start();
	}

}
