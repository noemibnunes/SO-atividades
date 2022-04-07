package Exercicio;

public class Buffer {

	private int buffer[] = new int[Produtor.N];
	private int count = 0, lo = 0, hi = 0;

	public synchronized void insert(int val) {

		if (count == Produtor.N) {
			goToSleep();
		}

		buffer[hi] = val;

		hi = (hi + 1) % Produtor.N;

		count = count + 1;

		if (count == 1) {
			notify();
		}
	}

	public synchronized int remove() {
		int val;

		if (count == 0) {
			goToSleep();
		}

		val = buffer[lo];

		lo = (lo + 1) % Produtor.N;

		count = count - 1;

		if (count == Produtor.N - 1) {
			notify();
		}

		return val;
	}

	private void goToSleep() {
		try {
			wait();
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}
}