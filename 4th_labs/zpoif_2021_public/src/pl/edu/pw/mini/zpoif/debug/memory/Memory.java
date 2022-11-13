package pl.edu.pw.mini.zpoif.debug.memory;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Memory {

	public static void main(String[] args) {
		try {
			Set<Set<String>> strings = new HashSet<>();
			doSomething(strings);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void doSomething(Set<Set<String>> strings) throws InterruptedException {
		// Set<Set<String>> strings = new HashSet<>();
		int singleSetSize = 30000;
		long sleepingTimeMs = 500;

		while (true) {
			Thread.sleep(sleepingTimeMs);
			strings.add(create(singleSetSize));
			randomRemove(strings);
			System.out.println("Current size: " + totalSize(strings));
		}
	}

	private static void randomRemove(Set<Set<String>> strings) {
		if (new Random().nextInt(3) == 0) {
			Iterator<Set<String>> setIterator = strings.iterator();
			if (setIterator.hasNext()) {
				setIterator.next();
				setIterator.remove();
				System.out.println("Something has been removed!!!");
			}
		}
	}

	private static Set<String> create(int n) {
		Set<String> result = new HashSet<String>();

		for (int i = 0; i < n; i++) {
			result.add(createRandoString());
		}

		return result;
	}

	private static String createRandoString() {
		byte[] array = new byte[64];
		new Random().nextBytes(array);
		return new String(array, Charset.forName("UTF-8"));
	}

	private static int totalSize(Set<Set<String>> set) {
		int result = 0;

		result = set.stream().collect(Collectors.summingInt(Set::size));

		return result;
	}

}
