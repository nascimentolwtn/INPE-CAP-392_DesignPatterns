package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.EventoMediator;
import br.inpe.cap.patterns.domain.Evento;
import br.inpe.cap.patterns.gerador.periodicidade.PeriodicidadeGeradorEventos;

public abstract class GeradorEventosAbstrato implements GeradorEventos, Runnable {
	
	private String string;
	protected PeriodicidadeGeradorEventos periodicidadeGeradorEventos;
	private EventoMediator eventoMediator;
	
	@Override
	public void setStringDoEvento(String string) {
		this.string = string;
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
	public void setEventoMediator(EventoMediator eventoMediator) {
		this.eventoMediator = eventoMediator;
	}
	
	@Override
	public void run() {
		while(true){
			
			Evento evento = this.gerarEvento(this.string);
			this.eventoMediator.notificaEventoProduzido(evento);

			try {
				Thread.sleep(this.doTimer());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}