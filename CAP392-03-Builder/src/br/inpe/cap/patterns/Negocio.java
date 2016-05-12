package br.inpe.cap.patterns;

import static br.inpe.cap.patterns.NegocioStrategy.NULL_STRATEGY;

public class Negocio {

	protected NegocioStrategy strategy;
	
	public Negocio() {
		this.strategy = NULL_STRATEGY;
	}
	
	public String executar() {
		return "negocio" + this.sulfixo() + this.strategy.getSulfixoStrategy();
	}

	protected String sulfixo() {
		return "";
	}
	
}
