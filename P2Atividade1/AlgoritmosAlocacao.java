package P2Atividade1;

public class AlgoritmosAlocacao {
	private static int ultimaAlocacaoNextFit = 0;

	public static boolean firstFit(boolean tamanho[], Processos processo) {
		int contados = 0;

		for (int i = 0; i < tamanho.length; i++) {
			if (!tamanho[i]) {
				contados++;
				if (contados == processo.getTamanhoAlocacao()) {
					processo.setPosicaoInicial(i - processo.getTamanhoAlocacao() + 1);
					return true;
				}
			} else {
				contados = 0;
			}
		}
		return false;
	}

	public static boolean bestFit(boolean tamanho[], Processos processo) {
		int contados = 0;
		int tamanhoIdeal = processo.getTamanhoAlocacao();
		boolean temEspacoLivre = false;

		for (int i = 0; i < tamanho.length; i++) {
			if (!tamanho[i] && contados < processo.getTamanhoAlocacao()) {
				contados++;
			} else {
				if (contados <= tamanhoIdeal) {
					tamanhoIdeal = contados;
					processo.setPosicaoInicial(i - processo.getTamanhoAlocacao());
					temEspacoLivre = true;
				}
				contados = 0;
			}
		}

		return temEspacoLivre;
	}

	public static boolean nextFit(boolean tamanho[], Processos processo) {
		int contados = 0;

		for (int i = ultimaAlocacaoNextFit; i < tamanho.length; i++) {
			if (!tamanho[i]) {
				contados++;
				if (contados == processo.getTamanhoAlocacao()) {
					processo.setPosicaoInicial(i - processo.getTamanhoAlocacao() + 1);
					ultimaAlocacaoNextFit = i + 1; 
					return true;
				}
			} else {
				contados = 0;
			}
		}

		return false;
	}

	public static boolean worstFit(boolean tamanho[], Processos processo) {
		int contados = 0;
		boolean temEspacoLivre = false;

		for (int i = 0; i < tamanho.length; i++) {
			if (!tamanho[i] && i < tamanho.length - 1) {
				contados++;
			} else {
				if (contados > processo.getTamanhoAlocacao()) {
					processo.setPosicaoInicial(i - contados);
					temEspacoLivre = true;
				}
				contados = 0;
			}
		}

		return temEspacoLivre;
	}
}
