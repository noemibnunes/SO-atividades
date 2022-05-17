package P2Atividade1;

public class Processos {

	private long id;
	private Integer tamanhoAlocacao;
    private Integer posicaoInicial;

	public Processos(long id, Integer tamanhoAlocacao) {
		this.id = id;
		this.tamanhoAlocacao = tamanhoAlocacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getTamanhoAlocacao() {
		return tamanhoAlocacao;
	}

	public void setTamanhoAlocacao(Integer tamanhoAlocacao) {
		this.tamanhoAlocacao = tamanhoAlocacao;
	}

	public Integer getPosicaoInicial() {
		return posicaoInicial;
	}

	public void setPosicaoInicial(Integer posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}

}
