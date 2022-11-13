package ZapisDoPliku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ZapisDoPliku {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] imiona = new String[] { "Anna", "Beata", "Julia", "Agnieszka", "Magdalena", "Maja", "Zdzis³awa",
				"Antonina", "Dominika", "Katarzyna" };
		String[] nazwiska = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		zapisDoPliku(imiona, nazwiska);
		ArrayList<Osoba> list = odczytZPliku();
//		for (int i = 0; i < 10; i++) {
//			System.out.println(list.get(i));
//		}
		statystykaImion(list, imiona);
		statystykaNazwisk(list, nazwiska);
		liczbaZdublowanych(list, imiona, nazwiska);
	}

	private static void zapisDoPliku(String[] imiona, String[] nazwiska) throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter(new File("ImionaNazwiskaWiek.txt"));
		for (int i = 0; i < 1000; i++) {
			int imie = new Random().nextInt(10);
			int nazwisko = new Random().nextInt(10);
			int wiek = new Random().nextInt(99) + 1;
			zapis.println(imiona[imie] + ";" + nazwiska[nazwisko] + ";" + wiek + ";");
		}
		zapis.close();
	}

	private static ArrayList<Osoba> odczytZPliku() {
		ArrayList<Osoba> listOfPeople = new ArrayList<Osoba>();
		try {
			BufferedReader odczyt = new BufferedReader(
					new InputStreamReader(new FileInputStream("ImionaNazwiskaWiek.txt")));
			String x;
			while ((x = odczyt.readLine()) != null) {
//			Osoba osoba = new Osoba(x);
				listOfPeople.add(new Osoba(x));
//			System.out.println(osoba);
			}
			odczyt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(listOfPeople);
		return listOfPeople;
	}

	private static void statystykaImion(ArrayList<Osoba> listOfPeople, String[] imiona) {
		HashMap<String, Integer> ileImion = new HashMap<>();
		for ( int i = 0; i< imiona.length; i++) {
			ileImion.put(imiona[i], 0);
		}
		int counter;
		int changedCounter;
		for (int i = 0; i < listOfPeople.size(); i++) {
			counter = ileImion.get(listOfPeople.get(i).imie).intValue();
			changedCounter = counter + 1;
			ileImion.replace(listOfPeople.get(i).imie, counter, changedCounter);
		}
		System.out.println("Liczba wystapien poszczegolnych imion: " + ileImion);
	}
	
	private static void statystykaNazwisk(ArrayList<Osoba> listOfPeople, String[] nazwiska) {
		HashMap<String, Integer> ileNazwisk = new HashMap<>();
		for ( int i = 0; i< nazwiska.length; i++) {
			ileNazwisk.put(nazwiska[i], 0);
		}
		int counter;
		int changedCounter;
		for (int i = 0; i < listOfPeople.size(); i++) {
			counter = ileNazwisk.get(listOfPeople.get(i).nazwisko).intValue();
			changedCounter = counter + 1;
//			System.out.println(changedDuplikat);
			ileNazwisk.replace(listOfPeople.get(i).nazwisko, counter, changedCounter);
		}
		System.out.println("Liczba wystapien poszczegolnych nazwisk: " + ileNazwisk);
	}
	
	private static void liczbaZdublowanych(ArrayList<Osoba> listOfPeople, String[] imiona, String[] nazwiska) {
		HashSet<String> imionaNazwiska = new HashSet<String>();
		for ( int i = 0; i< listOfPeople.size(); i++) {
			imionaNazwiska.add(listOfPeople.get(i).imie + listOfPeople.get(i).nazwisko);
		}
//		System.out.println(imionaNazwiska);
		int zdublowani = listOfPeople.size() - imionaNazwiska.size();
		System.out.println("Liczba osób zdublowanych: " + zdublowani);
	}

}
 