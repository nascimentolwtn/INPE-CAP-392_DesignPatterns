package br.inpe.cap.patterns.domain;

public class Evento {

	protected String string;
	
	public Evento(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return this.string;
	}

	public String print() {
		return this.toString();
	}
	
	
}
