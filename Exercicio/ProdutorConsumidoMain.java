package Exercicio;

public class ProdutorConsumidoMain {
	
	public static void main(String[] args) {
			
		Produtor.p.start(); 
		Produtor.c.start(); 
		int item = Produtor.p.produceItem();
		
		System.out.println("------- GERANDO NÚMERO ALEATÓRIO (entre 0 e 100000) -------");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Número gerado: " + item);
		System.out.println("O número gerado é primo: " + Produtor.c.ConsumidorItem(item));

	}
}
