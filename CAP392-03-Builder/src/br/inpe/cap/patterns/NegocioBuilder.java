package br.inpe.cap.patterns;

public class NegocioBuilder {

	public static Negocio createNegocio() {
		return new NegocioBasico();
	}

}
