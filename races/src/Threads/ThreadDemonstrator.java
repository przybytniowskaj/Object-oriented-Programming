package Threads;

import java.util.ArrayList;


public class ThreadDemonstrator {

	public static void main(String[] args) {
//		String msg = "Ala ma kota.";
//		MyFirstThread myFirstThread = new MyFirstThread(1, 10, msg);
//		myFirstThread.start();
		
//		Deamon deamon = new Deamon();
//		deamon.setDaemon(true);
//		deamon.start();
//		for (int i = 0; i<5; i++) {
//			System.out.println("main");
//		}
		ArrayList<Integer> tab = new ArrayList<>(java.util.List.of(3,6,2,5,3,9));
		modTablicy firstTab = new modTablicy(20, 3, tab);
		firstTab.start();
		modTablicy second = new modTablicy(11, 1, tab);
		second.start();
		modTablicy third = new modTablicy(30,1,tab);
		third.start();
		modTablicy fourth = new modTablicy(15,10,tab);
		fourth.start();
	}

}
