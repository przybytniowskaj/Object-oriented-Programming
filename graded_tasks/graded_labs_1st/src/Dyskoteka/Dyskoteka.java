package Dyskoteka;

import java.util.Random;

public class Dyskoteka {
	Hol hol;
	Sala salaMala;
	Sala salaDuza;
	OchroniarzMaly ochroniarzMaly;
	OchroniarzDuzy ochroniarzDuzy;
	
	public Dyskoteka() {
		this.hol = new Hol();
		this.salaDuza = new Sala(75);
		this.salaMala = new Sala(51);
		this.ochroniarzMaly = new OchroniarzMaly();
		this.ochroniarzDuzy = new OchroniarzDuzy();
	}
	
	public void  inviteAll() {
		for (int i = 0; i<hol.osobyWHolu.size(); i++) {
			boolean result = false;
			boolean los = new Random().nextBoolean();
			if (los == true) {
				result = ochroniarzMaly.check(hol.osobyWHolu.get(i), salaDuza, salaMala);
				if (result == true) {
					hol.osobyWHolu.remove(i);
					System.out.println("osoba " + i + " usunieta");
				}
			}else {
				result = ochroniarzDuzy.check(hol.osobyWHolu.get(i), salaDuza, salaMala);
				if (result == true) {
					hol.osobyWHolu.remove(i);
					System.out.println("osoba " + i + " usunieta");
				}
			}
		}
	}
	
	public void goLive() {
		this.inviteAll();
	}
	
	public void printStrangers() {
		ochroniarzDuzy.printStrangers();
	}
	
}
