package Lab_oceniany_3;

import java.util.ArrayList;

public class Myprocessor {

	public ArrayList<Pacjent> getWomanData(ArrayList<ArrayList<Pacjent>> kolekcja) {
		return kolekcja.get(0);
	}

	public ArrayList<ArrayList<Pacjent>> trimData(ArrayList<ArrayList<Pacjent>> kolekcja) {
		ArrayList<ArrayList<Pacjent>> powyzejtemp = new ArrayList<ArrayList<Pacjent>>();
		ArrayList<Pacjent> kobiety = new ArrayList<Pacjent>();
		ArrayList<Pacjent> mezczyzni = new ArrayList<Pacjent>();
		powyzejtemp.add(kobiety);
		powyzejtemp.add(mezczyzni);
		for (int i = 0; i < kolekcja.size(); i++) {
			for (Pacjent pacjent : kolekcja.get(i)) {
				if (pacjent.temp < 36.4) {
					continue;
				} else {
					powyzejtemp.get(i).add(pacjent);
				}
			}
		}
		return powyzejtemp;
	}

}
