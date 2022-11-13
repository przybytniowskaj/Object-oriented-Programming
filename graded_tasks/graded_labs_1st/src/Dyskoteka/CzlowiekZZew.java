package Dyskoteka;

import java.util.Random;

public class CzlowiekZZew extends Uczestnik{
	private int wiek;

	public CzlowiekZZew() {
		super();
		int wiek = new Random().nextInt(25)+16;
		this.wiek = wiek;
	}

}
