package br.inpe.cap.patterns;

public enum NegocioStrategy {
	
	NULL_STRATEGY(""),
	STRAT1("Strat1"),
	STRAT2("Strat2");
	
	private final String sulfixoStrategy;

	private NegocioStrategy(String sulfixo) {
		this.sulfixoStrategy = sulfixo;
	}
	
	public String getSulfixoStrategy() {
		return this.sulfixoStrategy; 
	}
}