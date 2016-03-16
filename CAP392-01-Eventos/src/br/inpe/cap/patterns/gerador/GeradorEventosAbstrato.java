package br.inpe.cap.patterns.gerador;

import br.inpe.cap.patterns.Enviador;
import br.inpe.cap.patterns.domain.Evento;

public abstract class GeradorEventosAbstrato extends Thread implements GeradorEventos {
	
	private String string;
	private Enviador enviador;
	
	@Override
	public void setString(String string) {
		this.string = string;
	}
	
	@Override
	public void setEnviador(Enviador enviador) {
		this.enviador = enviador;
	}

	@Override
	public Evento gerarEvento(String string) {
		return new Evento(string);
	}
	
	@Override
	public void iniciarGeracaoEventos() {
		this.start();
	}
	
	@Override
	public void run() {
		while(true){
			
			Evento evento = this.gerarEvento(this.string);
			this.enviador.notificaReceptores(evento);

			try {
				Thread.sleep(this.doTimer() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}