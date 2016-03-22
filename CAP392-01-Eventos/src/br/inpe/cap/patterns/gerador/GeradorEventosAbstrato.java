package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.Enviador;
import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.gerador.periodicidade.PeriodicidadeGeradorEventos;

public abstract class GeradorEventosAbstrato implements GeradorEventos, Runnable {
	
	private String string;
	private Enviador enviador;
	protected PeriodicidadeGeradorEventos periodicidadeGeradorEventos;
	
	@Override
	public void setStringDoEvento(String string) {
		this.string = string;
	}
	
	@Override
	public void setEnviador(Enviador enviador) {
		this.enviador = enviador;
	}
	
	@Override
	public long doTimer() {
		return this.periodicidadeGeradorEventos.getPeriodicidade();
	}

	@Override
	public Evento gerarEvento(String string) {
		return new Evento(string);
	}
	
	@Override
	public void run() {
		while(true){
			
			Evento evento = this.gerarEvento(this.string);
			this.enviador.notificaReceptores(evento);

			try {
				Thread.sleep(this.doTimer());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}