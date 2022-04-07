package Atividade2;

import java.util.Random;

public class GeradorDeProcessos {

	private static final Random RANDOM = new Random();
	private static final int MINIMO = 10;
	private static final int MAXIMO = 50;

	public static Processo novoPocesso() {

		Integer escalonar = RANDOM.nextInt((MAXIMO - MINIMO) + 1) + MINIMO;
		return new Processo(System.currentTimeMillis(), escalonar);
	}

}
