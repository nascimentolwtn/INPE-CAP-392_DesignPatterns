package br.inpe.cap.patterns;

public class NegocioBuilder {
	
	private Negocio negocio;

	public NegocioBuilder gerarNegocio() {
		negocio = new NegocioBasico();
		return this;
	}
	
	public NegocioBuilder comSulfixoSub1() {
		negocio = new NegocioSub1();
		return this;
	}

	public NegocioBuilder comSulfixoSub2() {
		negocio = new NegocioSub2();
		return this;
	}

	public NegocioBuilder comSulfixoStrategy(NegocioStrategy negocioStrategy) {
		negocio.setStrategy(negocioStrategy);
		return this;
	}

	public NegocioBuilder comoProxy() {
		negocio = new NegocioProxy(negocio);
		return this;
	}

	public Negocio construir() {
		return this.negocio;
	}
	
}
