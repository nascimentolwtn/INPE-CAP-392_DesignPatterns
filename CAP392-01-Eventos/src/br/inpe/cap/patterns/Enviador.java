package br.inpe.cap.patterns;

import java.util.ArrayList;
import java.util.List;

import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.gerador.GeradorEventos;
import br.inpe.cap.patterns.receptor.ReceptorEventos;

public class Enviador {

	private GeradorEventos geradorEventos;
	private String string;
	private List<ReceptorEventos> receptores;
	
	public Enviador(String string, GeradorEventos geradorEventos) {
		this.string = string;
		this.geradorEventos = geradorEventos;
		this.geradorEventos.setEnviador(this);
		this.geradorEventos.setString(string);
		this.receptores = new ArrayList<ReceptorEventos>();
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	public synchronized boolean addReceptor(ReceptorEventos receptor){
		return this.receptores.add(receptor);
	}
	
	public void enviarEventos() {
		this.geradorEventos.iniciarGeracaoEventos();
	}

	public synchronized void notificaReceptores(Evento evento) {
		for (ReceptorEventos receptorEventos : receptores) {
			receptorEventos.receberEvento(evento);
		}
	}

	
}
