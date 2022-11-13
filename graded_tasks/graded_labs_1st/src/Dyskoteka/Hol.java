package Dyskoteka;

import java.util.Stack;

public class Hol {
	Stack<Uczestnik> osobyWHolu;
	
	public Hol() {
		this.osobyWHolu = new Stack<Uczestnik>();
		for (int i = 0; i<33; i++) {
			osobyWHolu.add(new Student());
		}
		for (int j = 0; j<33; j++) {
			osobyWHolu.add(new Studentka());
		}
		for (int k = 0; k<33; k++) {
			osobyWHolu.add(new CzlowiekZZew());
		}
	}
}
