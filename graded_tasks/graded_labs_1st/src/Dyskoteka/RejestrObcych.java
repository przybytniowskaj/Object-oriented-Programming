package Dyskoteka;

import java.util.HashMap;
import java.util.HashSet;

public class RejestrObcych {
	HashMap<String, HashSet<CzlowiekZZew>> rejestr;
	
	public RejestrObcych() {
		this.rejestr = new HashMap<String, HashSet<CzlowiekZZew>>();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public boolean CzyJestWRejestrze(Uczestnik uczestnik) {
		if (rejestr.containsValue(uczestnik)==true) {
			return false;
		}else {
			return true;
		}
	}
	
}
