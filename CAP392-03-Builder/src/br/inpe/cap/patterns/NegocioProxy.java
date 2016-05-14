package br.inpe.cap.patterns;

public class NegocioProxy extends Negocio {

	private Negocio negocio;

	public NegocioProxy(Negocio negocio) {
		this.negocio = negocio;
	}
	
	@Override
	public String executar() {
		return this.negocio.executar() + "proxy";
	}

}
