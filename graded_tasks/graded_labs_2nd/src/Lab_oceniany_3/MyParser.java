package Lab_oceniany_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

public class MyParser {

	public ArrayList<ArrayList<Pacjent>> parsePatients(File file) throws Exception {
		ArrayList<ArrayList<Pacjent>> kolekcja = new ArrayList<ArrayList<Pacjent>>();
		ArrayList<Pacjent> kobiety = new ArrayList<Pacjent>();
		ArrayList<Pacjent> mezczyzni = new ArrayList<Pacjent>();
		kolekcja.add(kobiety);
		kolekcja.add(mezczyzni);
		HashSet<Integer> id = new HashSet<Integer>();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			String x;
			while ((x = reader.readLine()) != null) {
				Pacjent pacjent = new Pacjent(x);
				if (pacjent.x.equals("true") || pacjent.x.equals("false")) {
					kolekcja.get(1).add(new Mezczyzna(x));
				} else {
					kolekcja.get(0).add(new Kobieta(x));
				}
				if (id.contains(pacjent.id)) {
					throw new Exception("Id nie jest unikalne");
				} else {
					id.add(pacjent.id);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return kolekcja;
	}

}
