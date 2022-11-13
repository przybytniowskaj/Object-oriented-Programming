package Lab_oceniany_3;

import java.io.File;
import java.util.ArrayList;

public class DemonstratorPacjenci {

	public static void main(String[] args) throws Exception {

		MyParser parser = new MyParser();
		System.out.println("Prezentacja wczytanych pacjentow : ");
		ArrayList<ArrayList<Pacjent>> kolekcja = parser.parsePatients(new File("pacjenci_bad.txt"));
//		System.out.println(kolekcja.get(1).get(1));
		for (ArrayList<Pacjent> grupy : kolekcja) {
			for (int i = 0; i < grupy.size(); i++) {
				System.out.println(grupy.get(i));
			}
		}
		Myprocessor processor = new Myprocessor();
		System.out.println("----------");
		System.out.println("Prezentacja metody getWomanData:");
		ArrayList<Pacjent> kobiety = processor.getWomanData(kolekcja);
		for (Pacjent kobieta : kobiety)
			System.out.println(kobieta);

		System.out.println("-----------");
		System.out.println("Prezentacja metody trimdata: ");
		ArrayList<ArrayList<Pacjent>> powyzejTemp = processor.trimData(kolekcja);
		for (ArrayList<Pacjent> grupy : powyzejTemp) {
			for (int i = 0; i < grupy.size(); i++) {
				System.out.println(grupy.get(i));
			}
		}

	}

}
