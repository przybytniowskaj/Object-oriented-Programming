package Dyskoteka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class Uczestnik {
	private String imie;
	private String nazwisko;
	protected int wiek;
	protected int Id;
	private static int nextId = 0;
	
	public Uczestnik() {
		int los = new Random().nextInt(10);
		this.imie = tworzenieImion(los);
		this.nazwisko = tworzenieNazwisk(los);
		this.Id = nextId;
		nextId++;
	}
	
	private String tworzenieImion(int i) {
		ArrayList<String> imiona = new ArrayList<>();
		for (int j =0; j<10; j++) {
			imiona.add("a"+j);
		}
		return imiona.get(i);
	}
	
	private String tworzenieNazwisk(int i) {
		ArrayList<String> nazwiska = new ArrayList<>();
		for (int k =0; k<10; k++) {
			nazwiska.add("b"+i);
		}
		return nazwiska.get(i);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uczestnik other = (Uczestnik) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
	
	
}
