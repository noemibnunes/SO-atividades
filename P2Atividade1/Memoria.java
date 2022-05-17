package P2Atividade1;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	private static int TAMANHO = 1000;
	private final boolean  TAMANHO_MEMORIA[];
	private Integer espacoOcupado;
    private List<Processos> processos;
    
    public Memoria() {
    	this.TAMANHO_MEMORIA = new boolean[TAMANHO];
    	this.processos = new ArrayList<>();
    	this.espacoOcupado = 0;
    }
    
    public boolean[] getTamanhoMemoria() {
        return TAMANHO_MEMORIA;
    }

    public List<Processos> getProcessos() {
        return processos;
    }
    
    public Integer verificarEspacoLivre() {
        return TAMANHO_MEMORIA.length - espacoOcupado;
    }

    public Integer getEspacoOcupado() {
        return espacoOcupado;
    }
    
    public void adicionarProcesso(Processos processo) {
    	this.processos.add(processo);
    	this.espacoOcupado += processo.getTamanhoAlocacao();
    }
    
    public void removerProcesso(Processos processo) {
    	this.processos.remove(processo);
    	this.espacoOcupado -= processo.getTamanhoAlocacao();
    }
    
    public void updateProcesso(Integer posicaoInicial, Integer tamanhoAlocacao, boolean valor) {
    	 int alocacaoLimite = posicaoInicial + tamanhoAlocacao;

         for (int i = posicaoInicial; i != alocacaoLimite; i++) {
             TAMANHO_MEMORIA[i] = valor;
         }
    }
    
}
