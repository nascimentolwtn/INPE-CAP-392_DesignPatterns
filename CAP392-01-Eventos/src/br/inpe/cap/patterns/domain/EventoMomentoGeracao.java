package br.inpe.cap.patterns.domain;

public class EventoMomentoGeracao extends Evento {

	private long momentoGeracao;

	public EventoMomentoGeracao(String string) {
		super(string);
	}
	
	public EventoMomentoGeracao(String string, long momentoGeracao) {
		super(string);
		this.momentoGeracao = momentoGeracao;
	}

	public long getMomentoGeracao() {
		return momentoGeracao;
	}

	public void setMomentoGeracao(long momentoGeracao) {
		this.momentoGeracao = momentoGeracao;
	}
	
	@Override
	public String print() {
		return this.string + " (Momento geração: " + this.momentoGeracao + ")";
	}

}
