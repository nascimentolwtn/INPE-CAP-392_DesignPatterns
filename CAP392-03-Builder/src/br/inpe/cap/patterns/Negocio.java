package br.inpe.cap.patterns;

public class Negocio {

	public String executar() {
		return "negocio" + this.sulfixo();
	}

	protected String sulfixo() {
		return "";
	}
	
}
