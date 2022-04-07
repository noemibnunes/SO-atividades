package Exercicio;

public class Consumidor extends Thread {

	public void run() {
		int item;

		while (true) {
			item = Produtor.mon.remove();
			ConsumidorItem(item);
		}
	}

	boolean ConsumidorItem(int item) {

		if (item <= 1) {
			return false;
		}
		
		for (int i = 2; i < item; i++) {
			if (item % i == 0) {
				return false;
			} 
		}
		return true;
	}
}
