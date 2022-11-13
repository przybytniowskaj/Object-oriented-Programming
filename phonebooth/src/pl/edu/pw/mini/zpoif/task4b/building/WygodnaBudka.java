package pl.edu.pw.mini.zpoif.task4b.building;

import pl.edu.pw.mini.zpoif.task4b.furniture.WygodnaSofaRozkladana;

public class WygodnaBudka extends Budka {

	protected WygodnaSofaRozkladana wersalka;
	protected Sejf sejf = new Sejf();
	private String szyfrDoSejfu = "11R-22L-33R";
	private String napisNaScianie = "Killroy was here!";

	private String nazwa;
	private String producent;
	private int kodProducenta;
	private int pojemnosc;

	private class Sejf {

		public void open(String szyfr) {
			if ("11L-22R-33L".equals(szyfr)) {
				System.out.println("Sezam otwarty!");
			} else {
				System.out.println("Uuuu, ktos tu nie wykonal zadania nr 3...");
			}
		}
	}

	public WygodnaBudka() {
	}

	public WygodnaBudka(String nazwa, String producent) {
		this.nazwa = nazwa;
		this.producent = producent;
	}

	public WygodnaBudka(String nazwa, int kodProducenta) {
		this.nazwa = nazwa;
		this.kodProducenta = kodProducenta;
	}

	public WygodnaBudka(int kodProducenta, int pojemnosc) {
		this.kodProducenta = kodProducenta;
		this.pojemnosc = pojemnosc;
	}

	@Override
	public String toString() {
		return "WygodnaBudka [sofa=" + wersalka + ", sejf=" + sejf + ", szyfrDoSejfu=" + szyfrDoSejfu + ", napisNaScianie="
				+ napisNaScianie + "]";
	}

}
