package br.inpe.cap.patterns;

public class NegocioSub1 extends Negocio {

	public NegocioSub1() {
		super();
	}
	
	public NegocioSub1(NegocioStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	protected String sulfixo() {
		return "sub1";
	}
	
}
