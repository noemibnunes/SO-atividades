package P2Atividade1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	private static final Random RANDOM = new Random();
    private static final int DELAY = 0;   
    private static final int INTERVAL = 1000; 
    private static final int DURANTION = 100; 
    private static final Timer TIMER = new Timer();
    private static final Memoria MEMORIA = new Memoria(); 
    private static final List<Processos> ALOCAR_PROCESSOS = new ArrayList<>();
    private static double PROCESSOS_ALOCADOS = 0;
    private static double OCUPACAO_MEMORIA = 0;

    public static void main(String[] args) {
    	
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Escolha um Algoritmo de Alocação: " + "\n(1) First Fit" + "\n(2) Best Fit" + "\n(3) Next Fit" + "\n(4) Worst Fit");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		int algoritmoEscolhido = teclado.nextInt();
		
        TIMER.schedule(new TimerTask() {
            int contadorTime = 0;

            public void run() {
            	contadorTime++;

                criarEAlocarProcesso(algoritmoEscolhido);
                System.out.println("Ocupação da Memória: " + MEMORIA.getEspacoOcupado() +"\n");

                if (contadorTime == DURANTION) {
                    TIMER.cancel();
                    exercicio();
                }
            }
        }, DELAY, INTERVAL);
        
        teclado.close();
    }

    public static void criarEAlocarProcesso(int algoritmo) {
        List<Processos> processos = criarProcesso();

        escolherMetodoAlocacao(algoritmo, processos);

        removerProcesso();
    }

    private static void escolherMetodoAlocacao(int algoritmo, List<Processos> processos) {
        switch (algoritmo) {
            case 1:
                addProcessoFirstFit(processos);
                break;
            case 2:
            	addProcessoBestFit(processos);
                break;
            case 3:
            	addProcessoWorstFit(processos);
                break;
            case 4:
                addProcessoNextFit(processos);
                break;
            default:
                System.out.println("Opção Inválida!");

        }
    }

    private static void removerProcesso() {
        int remove = RANDOM.nextInt(2) + 1;

        for (int i = 0; i < remove; i++) {
            if(MEMORIA.getProcessos().size() > 0) {
                int positionElementRemove = RANDOM.nextInt(MEMORIA.getProcessos().size());
                Processos processo = MEMORIA.getProcessos().get(positionElementRemove);
                MEMORIA.removerProcesso(processo);
                System.out.printf("Removendo processo: %s%n", processo.getId());
            }
        }
    }

    private static List<Processos> criarProcesso() {
        Processos process1 = GeradorDeProcessos.novoPocesso();
        Processos process2 = GeradorDeProcessos.novoPocesso();
        PROCESSOS_ALOCADOS += process1.getTamanhoAlocacao() + process2.getTamanhoAlocacao();

        System.out.printf("Gerando processos %s e %s%n", process1.getId(), process2.getId());
        return Arrays.asList(process1, process2);
    }

    private static void addProcessoFirstFit(List<Processos> processos) {
    	processos.forEach(processo -> {
            if (processo.getTamanhoAlocacao() > MEMORIA.verificarEspacoLivre() || !AlgoritmosAlocacao.firstFit(MEMORIA.getTamanhoMemoria(), processo)) {
            	ALOCAR_PROCESSOS.add(processo);
                System.out.printf("Descartando processo: %s%n", processo.getId());
            } else {
                MEMORIA.adicionarProcesso(processo);
                OCUPACAO_MEMORIA += processo.getTamanhoAlocacao();
            }
        });
    	OCUPACAO_MEMORIA = OCUPACAO_MEMORIA / 2;
    }

    private static void addProcessoBestFit(List<Processos> processos) {
        processos.forEach(processo -> {
            if (processo.getTamanhoAlocacao() > MEMORIA.verificarEspacoLivre() || !AlgoritmosAlocacao.bestFit(MEMORIA.getTamanhoMemoria(), processo)) {
                ALOCAR_PROCESSOS.add(processo);
                System.out.printf("Descartando processo: %s%n", processo.getId());
            } else {
                MEMORIA.adicionarProcesso(processo);
                OCUPACAO_MEMORIA += processo.getTamanhoAlocacao();
            }
        });
        OCUPACAO_MEMORIA = OCUPACAO_MEMORIA / 2;
    }

    private static void addProcessoNextFit(List<Processos> processos) {
        processos.forEach(processo -> {
            if (processo.getTamanhoAlocacao() > MEMORIA.verificarEspacoLivre() || !AlgoritmosAlocacao.nextFit(MEMORIA.getTamanhoMemoria(), processo)) {
                ALOCAR_PROCESSOS.add(processo);
                System.out.printf("Descartando processo: %s%n", processo.getId());
            } else {
                MEMORIA.adicionarProcesso(processo);
                OCUPACAO_MEMORIA += processo.getTamanhoAlocacao();
            }
        });
        OCUPACAO_MEMORIA = OCUPACAO_MEMORIA / 2;
    }

    private static void addProcessoWorstFit(List<Processos> processos) {
        processos.forEach(processo -> {
            if (processo.getTamanhoAlocacao() > MEMORIA.verificarEspacoLivre() || !AlgoritmosAlocacao.worstFit(MEMORIA.getTamanhoMemoria(), processo)) {
                ALOCAR_PROCESSOS.add(processo);
                System.out.printf("Descartando processo: %s%n", processo.getId());
            } else {
                MEMORIA.adicionarProcesso(processo);
                OCUPACAO_MEMORIA += processo.getTamanhoAlocacao();
            }
        });
        OCUPACAO_MEMORIA = OCUPACAO_MEMORIA / 2;
    }
    
    public static void exercicio() {
        double descarteTaxa = ALOCAR_PROCESSOS.size();
        PROCESSOS_ALOCADOS = PROCESSOS_ALOCADOS / (MEMORIA.getProcessos().size() + ALOCAR_PROCESSOS.size());

        System.out.println("===========================================================");
        System.out.printf("Tamanho médio do processos: %s%n", PROCESSOS_ALOCADOS);
        System.out.printf("Ocupação média da memória: %ss%n", OCUPACAO_MEMORIA);
        System.out.printf("Taxa de descarte: %s%n", descarteTaxa / 100);
        System.out.println("===========================================================");
    }
    
}
