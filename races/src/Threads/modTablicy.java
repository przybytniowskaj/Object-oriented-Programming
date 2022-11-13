package Threads;

import java.util.ArrayList;

public class modTablicy extends Thread{
	private int mojaLiczba;
	private int mojSen;
	private ArrayList<Integer> tab;
	
	
	public modTablicy(int mojaLiczba, int mojSen, ArrayList<Integer> tab) {
		super();
		this.mojaLiczba = mojaLiczba;
		this.mojSen = mojSen;
		this.tab = tab;
	}

	@Override
	public void run() {
		int najmniejszyIndeks = 0;
		for (int i = 1; i< tab.size(); i++) {
			if(tab.get(i)<tab.get(najmniejszyIndeks)) {
				najmniejszyIndeks = i;
			}
		}
		tab.set(najmniejszyIndeks, mojaLiczba);
		System.out.println(tab);
	}

}
