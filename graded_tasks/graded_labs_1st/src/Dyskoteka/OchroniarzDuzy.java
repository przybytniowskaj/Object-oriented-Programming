package Dyskoteka;

import java.util.Iterator;
import java.util.Random;

public class OchroniarzDuzy extends OchroniarzMaly{
	
	protected RejestrObcych rejestr;
	
	public OchroniarzDuzy() {
		this.rejestr = new RejestrObcych();
	}

	public boolean check(Uczestnik uczestnik, Sala salaDuza, Sala salaMala) {
		if (uczestnik.wiek >= 18) {
			int los = new Random().nextInt(2);
			if (los==0 && salaMala.osobyNaSali.size() < salaMala.pojemnosc) {
				salaMala.osobyNaSali.add(uczestnik);
				System.out.println("Uczestnik dodany do sali malej przez ODuzego");
//				if (uczestnik)
			}else if (los==1 && salaDuza.osobyNaSali.size() < salaDuza.pojemnosc){
				salaDuza.osobyNaSali.add(uczestnik);
				System.out.println("Uczestnik dodany do sali duzej przez ODuzego");
			}
			return true;	
		}
		return false;
	}

	
	public void printStrangers() {
//		String napis;
//		for (int i = 0; i<rejestr.rejestr.size(); i++) {
//			napis+=rejestr.rejestr.
//		}
	}
	

	
}
