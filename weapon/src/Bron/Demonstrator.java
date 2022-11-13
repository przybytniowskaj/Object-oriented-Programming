package Bron;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Demonstrator {
	public static void main(String[] args) throws IOException {
		File file = new File("generated_weapon.txt");
		Operation operation = new Operation();
		ArrayList<Weapon> listOfWeapon = operation.readLines(file);
		HashMap<Caliber, ArrayList<Weapon>> sortedWeapon = operation.getSortedWeapon(listOfWeapon);
		operation.writeSortedWeapon(sortedWeapon);
	}
	
	
}
