package Dyskoteka;


import java.util.Random;

public class Student extends Uczestnik{
	private int wiek;

	public Student() {
		super();
		int wiek = new Random().nextInt(9)+18;
		this.wiek = wiek;
	}
	
	
}
