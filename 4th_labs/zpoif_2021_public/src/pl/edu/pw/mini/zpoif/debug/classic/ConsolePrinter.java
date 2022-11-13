package pl.edu.pw.mini.zpoif.debug.classic;

import java.util.Random;

public class ConsolePrinter {
	private String prefix;

	public ConsolePrinter(String prefix) {
		this.prefix = prefix;
	}

	public void printMessage(String message) {
		System.out.println(" >> " + prefix + " << ------ " + message);
	}

	public static void printAndDoSomethingExtra() {
		System.out.println("Today random number is: " + new Random().nextInt(100));
	}

}
