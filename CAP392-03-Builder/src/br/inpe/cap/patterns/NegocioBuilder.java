package br.inpe.cap.patterns;

public class NegocioBuilder {
	
	private Negocio negocio;

	public NegocioBuilder gerarNegocio() {
		negocio = new NegocioBasico();
		return this;
	}
	
	public NegocioBuilder comSulfixoSub1() {
		NegocioSub1 negocioSub1 = new NegocioSub1();
		negocioSub1.setStrategy(this.negocio.getStrategy());
		this.negocio = negocioSub1;
		return this;
	}

	public NegocioBuilder comSulfixoSub2() {
		NegocioSub2 negocioSub2 = new NegocioSub2();
		negocioSub2.setStrategy(this.negocio.getStrategy());
		this.negocio = negocioSub2;
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
