package br.inpe.cap.patterns;

import java.util.ArrayList;
import java.util.List;

import br.inpe.cap.patterns.gerador.GeradorEventos;
import br.inpe.cap.patterns.receptor.ReceptorEventos;

public class Enviador {

	private GeradorEventos geradorEventos;
	private String string;
	private List<ReceptorEventos> receptores;
	
	public Enviador(String string, GeradorEventos geradorEventos) {
		this.string = string;
		this.geradorEventos = geradorEventos;
		this.receptores = new ArrayList<ReceptorEventos>();
	}

	public GeradorEventos getGeradorEventos() {
		return geradorEventos;
	}

	public void setGeradorEventos(GeradorEventos geradorEventos) {
		this.geradorEventos = geradorEventos;
	}
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	public boolean addReceptor(ReceptorEventos receptor){
		return this.receptores.add(receptor);
	}
	
	public void enviarEventos() {
		for (ReceptorEventos receptorEventos : receptores) {
			receptorEventos.receberEvento(this.geradorEventos.gerarEvento(this.string));
		}
	}

	
}
