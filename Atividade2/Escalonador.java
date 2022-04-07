package Atividade2;

import java.util.ArrayList;
import java.util.List;

public interface Escalonador {
	
    List<Processo> processos = new ArrayList<>();
	
	public Processo obterProcesso();

	public void removerProcesso(Processo processo);

	public void adicionarProcesso(Processo processo);

	public Boolean existeProcesso();
	
    public abstract int getQuantun();


}
