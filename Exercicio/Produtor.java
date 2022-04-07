package Exercicio;

import java.util.Random;

public class Produtor extends Thread {

	static final int N = 100; 
	static Produtor p = new Produtor(); 
	static Consumidor c = new Consumidor(); 
	static Buffer mon = new Buffer(); 

	public void run() {
		int item;

		while (true) {
			item = produceItem();
			mon.insert(item);
		}
	}

	protected int produceItem() {
		Random numerosAleatorios = new Random();

		return numerosAleatorios.nextInt(1000000);
	}
}
