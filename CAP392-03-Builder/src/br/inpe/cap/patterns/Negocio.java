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

	/**
	 * Hook-method para adição do sulfixo
	 * @return Sulfixo
	 */
	protected String sulfixo() {
		return "";
	}

	public void setStrategy(NegocioStrategy strategy) {
		this.strategy = strategy;
	}
	
}
