package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.domain.Evento;

public abstract class GeradorEventosAbstrato extends Thread implements GeradorEventos {
	
	private String string;
	
	@Override
	public void setString(String string) {
		this.string = string;
	}

	@Override
	public Evento gerarEvento(String string) {
		return new Evento(string);
	}
	
	@Override
	public void gerarEventos() {
		this.start();
	}
	
	@Override
	public void run() {
		while(true){
			
			Evento evento = this.gerarEvento(this.string);
			
			//FIXME Impressão aqui apenas para teste. Fazer impressão correta ReceptorEventos
			System.out.println(evento.print());
			
			try {
				Thread.sleep(this.doTimer() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}