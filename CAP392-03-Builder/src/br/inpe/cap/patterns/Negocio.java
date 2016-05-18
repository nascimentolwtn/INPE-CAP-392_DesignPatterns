package br.inpe.cap.patterns;

public interface Negocio {

	String executar();

	void setStrategy(NegocioStrategy strategy);

	NegocioStrategy getStrategy();

}