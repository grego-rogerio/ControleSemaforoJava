package com.controle.semaforo;

import com.controle.semaforo.controller.SemaforoThread;

public class ControleSemaforo {

	
	public static void main(String []args) {
		SemaforoThread semaforo = new SemaforoThread();
		
		for(int i=0;i<9;i++) {
			System.out.println("Cor: " + semaforo.getCor());
			semaforo.executarThread();
		}
		semaforo.cancel();
	}
}
