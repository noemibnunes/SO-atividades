package Atividade2;

import java.util.Scanner;

public class CPUMain {

	public static final Integer INT_CLOCK = 3;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner tecladoEscalonador = new Scanner(System.in);
		System.out.println("Escolha o Escalonador: " + "\n(1) SJF" + "\n(2) FCFS" + "\n(3) Robin Round");
		System.out.println("--------------------------------------------------------------------------");

		int escalonadorEscolhido = tecladoEscalonador.nextInt();
		CPU cpu = new CPU(tipoEscalonador(escalonadorEscolhido));

		cpu.tipoEscalonador.adicionarProcesso(GeradorDeProcessos.novoPocesso());
		cpu.executarProcesso();

	}

	// pega o tipo de escalonador
	private static Escalonador tipoEscalonador(int tipo) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Escalonador escalonador = null;
		switch (tipo) {
		case 1:
			escalonador = new SJF();
			break;
		case 2:
			escalonador = new FCFS();
			break;
		case 3:
			System.out.println("Quantum: ");
			int quantum = sc.nextInt();
			escalonador = new RoundRobin(quantum);
		}
		return escalonador;
	}
}
