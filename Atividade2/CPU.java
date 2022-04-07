package Atividade2;

public class CPU {
	private static final Long CICLOS = 3L;	
	Escalonador tipoEscalonador;

	public CPU (Escalonador tipoEscalonador) {
		this.tipoEscalonador = tipoEscalonador;
	}
	
	public void executarProcesso() {
		System.out.println("\n---------------------- INICIO DA EXECUÇÃO ----------------------");
		while (tipoEscalonador.existeProcesso()) {
			Processo processo = tipoEscalonador.obterProcesso();
			
			for (int i = 0; i < CICLOS && processo.existeInstrucao(); i++) {
				processo.decrementarQtdInstrucoes();
				System.out.println(
						"Restam: " + processo.getQuantidadeInstrucoes() + " processos.");

			}

			if (!processo.existeInstrucao()) {
				tipoEscalonador.removerProcesso(processo);
                System.out.println("\n---------------------- EXECUÇÃO CONCLUIDA ----------------------");
			}
		}
	}

}