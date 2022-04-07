package Atividade2;

public class Processo {

	private long id;
	private long quantidadeInstrucoes;

	public Processo(long id, long quantidadeInstrucoes) {
		this.id = id;
		this.quantidadeInstrucoes = quantidadeInstrucoes;
	}

	public void decrementarQtdInstrucoes() {
		System.out.println("\n------------------- INSTRUÇÃO FINALIZADA -----------------------");
		System.out.println("\nInstrução finalizada: " + id);
		quantidadeInstrucoes--;
	}

	public boolean isProcessoFinalizado() {
		return quantidadeInstrucoes == 0;
	}

	public boolean existeInstrucao() {
		return quantidadeInstrucoes > 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantidadeInstrucoes() {
		return quantidadeInstrucoes;
	}

	public void setQuantidadeInstrucoes(long quantidadeInstrucoes) {
		this.quantidadeInstrucoes = quantidadeInstrucoes;
	}

}
