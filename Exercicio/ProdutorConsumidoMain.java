package Exercicio;

public class ProdutorConsumidoMain {
	
	public static void main(String[] args) {
			
		Produtor.p.start(); 
		Produtor.c.start(); 
		int item = Produtor.p.produceItem();
		
		System.out.println("------- GERANDO N�MERO ALEAT�RIO (entre 0 e 100000) -------");
		System.out.println("-----------------------------------------------------------");
		System.out.println("N�mero gerado: " + item);
		System.out.println("O n�mero gerado � primo: " + Produtor.c.ConsumidorItem(item));

	}
}
