package com.controle.semaforo.controller;

enum SemaforoCor {
	VERMELHO, AMARELO, VERDE 
}

public class SemaforoThread implements Runnable{
private SemaforoCor cor = SemaforoCor.VERMELHO;
private Thread trd;
private boolean stop = false;

public SemaforoThread() {
	trd = new Thread(this);
	trd.start();
}
	
	@Override
	public void run() {
		while(!stop) {
		alterarCor();
		}
		
	}
	
	public synchronized void executarThread() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized void alterarCor() {
		switch(cor) {
		case VERMELHO: cor=SemaforoCor.VERDE;
		break;
		case VERDE:cor=SemaforoCor.AMARELO;
		break;
		case AMARELO:cor=SemaforoCor.VERMELHO;
		break;
		}
		notify();
	}
	
	public SemaforoCor getCor() {
		return cor;
	}
	
	public void cancel() {
		this.stop=true;
	}

}
