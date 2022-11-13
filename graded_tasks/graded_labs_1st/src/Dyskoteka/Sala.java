package Dyskoteka;

import java.util.LinkedHashSet;

public class Sala {
	LinkedHashSet<Uczestnik> osobyNaSali;
	int pojemnosc;
	
	public Sala(int pojemnosc) {
		this.osobyNaSali = new LinkedHashSet<Uczestnik>(pojemnosc);
		this.pojemnosc = pojemnosc;
	}
}
