package br.inpe.cap.patterns;

public class NegocioProxy implements Negocio {

	private Negocio negocio;
	
	public NegocioProxy(Negocio negocio) {
		this.negocio = negocio;
	}
	
	@Override
	public String executar() {
		return this.negocio.executar() + "proxy";
	}

	@Override
	public void setStrategy(NegocioStrategy strategy) {
		this.negocio.setStrategy(strategy);
	}

}
