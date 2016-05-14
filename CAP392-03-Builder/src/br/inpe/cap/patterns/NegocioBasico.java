package br.inpe.cap.patterns;

import static br.inpe.cap.patterns.NegocioStrategy.NULL_STRATEGY;

public class NegocioBasico implements Negocio {

	protected NegocioStrategy strategy;
	
	public NegocioBasico() {
		this.strategy = NULL_STRATEGY;
	}
	
	@Override
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

	@Override
	public void setStrategy(NegocioStrategy strategy) {
		this.strategy = strategy;
	}
	
}
