package P2Atividade1;

import java.util.Random;

public class GeradorDeProcessos {
	private static final int MINIMO = 10;
	private static final int MAXIMO = 50;
	private static int ID = 0;

	private static final Random RANDOM = new Random();
    
	public GeradorDeProcessos() {}

	public static Processos novoPocesso() {
		Integer tamanhoAlocacao = RANDOM.nextInt((MAXIMO - MINIMO) + 1) + MINIMO;
		return new Processos(ID++, tamanhoAlocacao);
	}
}
