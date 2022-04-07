package Atividade2;

public class RoundRobin implements Escalonador {
	
	private int quantum;

    public RoundRobin(int quantum) {
        this.quantum = quantum;
    }

	public Processo obterProcesso() {
		return processos.get(0);
	}

	@Override
	public void adicionarProcesso(Processo processo) {
		processos.add(processo);
	}

	@Override
	public Boolean existeProcesso() {
		return !processos.isEmpty();
	}

	public void interromperProcesso() {
		processos.add(processos.get(0));
		processos.remove(0);
	}
	
	public void removerProcesso(Processo processo) {
		if(processo.existeInstrucao()) {
			interromperProcesso();
		}
		processos.remove(processo);
	}

	@Override
	public int getQuantun() {
        return this.quantum;
	}
}
