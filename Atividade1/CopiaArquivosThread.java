package Atividade1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiaArquivosThread {

	private static final int LIMITE = 10; // quantidade de copias
	private static final String EXTENSAO_ARQUIVO = ".txt";

	static long tm = 0;

	public static void main(String[] args) {

		try {
			System.out.println("--- Iniciando a execução ---\n");

			copiar("arquivo.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoDois.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoTres.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoQuatro.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoQuinto.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoSexto.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoSetimo.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoOitavo.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoNono.txt"); // substitui pelo caminho do arquivo
			copiar("arquivoDecimo.txt"); // substitui pelo caminho do arquivo

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copiar(String arquivo) throws IOException {

		new Thread() {
			long tempInicial = System.currentTimeMillis();
			@Override
			public void run() {
				for (int count = 1; count <= LIMITE; count++) {
					long tempoInicio = System.currentTimeMillis();
					String nomeArquivo = arquivo.replace(EXTENSAO_ARQUIVO, "");
					File novoArquivo = new File(nomeArquivo + count + EXTENSAO_ARQUIVO);

					try {
						InputStream arquivoRecebido = new FileInputStream(arquivo);
						OutputStream arquivoCopia = new FileOutputStream(novoArquivo);

						byte[] bf = new byte[1024];
						int tamanho;
						while ((tamanho = arquivoRecebido.read(bf)) > 0) {
							arquivoCopia.write(bf, 0, tamanho);
						}

						arquivoRecebido.close();
						arquivoCopia.close();

						System.out.println(nomeArquivo + " : " + (System.currentTimeMillis() - tempoInicio) + "ms");

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				long tempFinal = System.currentTimeMillis();
                long dif = (tempFinal - tempInicial);
                System.out.println(arquivo + " - Requisição " + ": " + String.format("%02d segundos  e %02d milisegundos", dif/60, dif%60));
			}
		}.start();
	} 

}
