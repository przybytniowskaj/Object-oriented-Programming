package Dyskoteka;

import java.util.Random;

public class OchroniarzMaly {

	
	public boolean check(Uczestnik uczestnik, Sala salaDuza, Sala salaMala) {
		if (uczestnik.wiek >= 18) {
			int los = new Random().nextInt(2);
			if (los==0 && salaMala.osobyNaSali.size() < salaMala.pojemnosc) {
				salaMala.osobyNaSali.add(uczestnik);
				System.out.println("Uczestnik dodany do sali malej przez OMalego");
			}else if (los==1 && salaDuza.osobyNaSali.size() < salaDuza.pojemnosc){
				salaDuza.osobyNaSali.add(uczestnik);
				System.out.println("Uczestnik dodany do sali duzej przez OMalego");
			}
			return true;	
		}
		return false;
	}
	
}
