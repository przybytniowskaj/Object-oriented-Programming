package Dyskoteka;

public class Demonstrator {

	public static void main(String[] args) {
		Dyskoteka dyskoteka = new Dyskoteka();
		for (int i =0; i<dyskoteka.hol.osobyWHolu.size(); i++) {
			System.out.print(dyskoteka.hol.osobyWHolu.get(i).Id + " ");
		}
		dyskoteka.goLive();
		dyskoteka.printStrangers();
		
	}

}
