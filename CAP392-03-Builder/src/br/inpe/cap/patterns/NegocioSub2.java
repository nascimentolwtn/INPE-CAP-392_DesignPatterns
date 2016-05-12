package br.inpe.cap.patterns;

public class NegocioSub2 extends Negocio {

	public NegocioSub2() {
		super();
	}

	public NegocioSub2(NegocioStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	protected String sulfixo() {
		return "sub2";
	}
	
}
