package pl.edu.pw.mini.zpoif.debug.classic;

//import java.util.ArrayList;
//import java.util.List;

public class Ticker {

	private static final String WELCOME_MESSAGE = "Hi, let`s start!";

	public static void main(String[] args) {
		try {
			go();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void go() throws InterruptedException {

//		List<String> list = new ArrayList<>();
//		list.add("Tom");
//		list.add("sth");
		
		boolean continueFlag = true;
		long sleepingTimeMs = 200;
		ConsolePrinter consolePrinter = new ConsolePrinter("My printer!");
		consolePrinter.printMessage(WELCOME_MESSAGE);
		while (continueFlag) {
//			continueFlag =false;
			Thread.sleep(sleepingTimeMs);
			consolePrinter.printMessage("Has just woke up!");
//			System.out.println("hello?");
		}
		consolePrinter.printMessage("Good bye");

	}

}
