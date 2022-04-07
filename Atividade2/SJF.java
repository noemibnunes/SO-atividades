package Atividade2;

public class SJF implements Escalonador {

	@Override
	public Processo obterProcesso() {
		return processos.get(0);
	}

	@Override
	public void adicionarProcesso(Processo processo) {
		processos.add(processo);
	}

	@Override
	public void removerProcesso(Processo processo) {
		processos.remove(processo);
	}

	@Override
	public Boolean existeProcesso() {
		return !processos.isEmpty();
	}

	@Override
	public int getQuantun() {
		return 0;
	}

}
