package Dyskoteka;

import java.util.Random;

public class Studentka extends Uczestnik{
	private int wiek;

	public Studentka() {
		super();
		int wiek = new Random().nextInt(9)+18;
		this.wiek = wiek;
	}

}
