package Atividade1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiaArquivos {

	private static final int LIMITE = 10; // quantidade de copias
	private static final String EXTENSAO_ARQUIVO = ".txt";


	public static void main(String[] args) {

		long tempoInicio = System.currentTimeMillis();

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

		System.out.println(
				"--- Execução concluída! --- \nTempo total de execução: " + (System.currentTimeMillis() - tempoInicio) + "ms");
	}

	public static void copiar(String arquivo) throws IOException {
		
		for (int count = 1; count <= LIMITE; count++) {
			long tempoInicio = System.currentTimeMillis();
			String nomeArquivo = arquivo.replace(EXTENSAO_ARQUIVO, "");
			File novoArquivo = new File(nomeArquivo + count + EXTENSAO_ARQUIVO);

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
			
			if(count == 10) {
				System.out.println("\n-----------------------------");
			}

		}
	}

}
