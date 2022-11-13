package GeneralTools;

import java.util.Random;

public class Randomizer {
	private static int seed = new Random().nextInt();
	private static final Random random = new Random(seed);

	public static int getSeed() {
		return seed;
	}

	public static void setSeed(int seed) {
		Randomizer.seed = seed;
		random.setSeed(seed);
	}

	public static int randomInt(int from, int to) {
		return random.nextInt(to - from + 1) + from;
	}

	public static int randomInt(int bound) {
		return random.nextInt(bound);
	}

}
