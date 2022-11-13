package Bron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Operation implements OperationIF {

	@Override
	public ArrayList<Weapon> readLines(File file) {
		int sum = 0;
		ArrayList<Weapon> listOfWeapons = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String x;
			while ((x = reader.readLine()) != null) {
				if (x.matches("\\p{L}.*")) {
					listOfWeapons.add(new Weapon(x));
					sum++;
//				System.out.println(weapon);
//				System.out.println(listOfWeapon.get(i));
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Liczba wyczytanych egzemplarzy: " + sum);
		return listOfWeapons;
	}

	@Override
	public HashMap<Caliber, ArrayList<Weapon>> getSortedWeapon(ArrayList<Weapon> listOfWeapon) {
		HashMap<Caliber, ArrayList<Weapon>> sortedWeapon = new HashMap<>();
		for (Weapon weapon : listOfWeapon) {
			if (sortedWeapon.containsKey(weapon.caliber)) {
				sortedWeapon.get(weapon.caliber).add(weapon);
			} else {
				sortedWeapon.put(weapon.caliber, new ArrayList<Weapon>());
				sortedWeapon.get(weapon.caliber).add(weapon);
			}
		}
		return sortedWeapon;
	}

	public void writeSortedWeapon(HashMap<Caliber, ArrayList<Weapon>> sortedWeapon) {
		Collection<ArrayList<Weapon>> listOfWeapon = sortedWeapon.values();
		for (ArrayList<Weapon> weaponSameCaliber : listOfWeapon) {
			int count = 0;
			try {
//				System.out.println(weaponSameCaliber);
				PrintWriter writer = new PrintWriter("Weapon_" + weaponSameCaliber.get(0).caliber.value + ".txt");
				for (Weapon weapon : weaponSameCaliber) {
					writer.write(weapon.toString() + System.lineSeparator());
					count++;
				}
				writer.close();
				System.out.println("liczba wpisanych kalibrow rodzaju " + weaponSameCaliber.get(0).caliber + " wynosi: "+ count);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void serialise(ArrayList<Weapon> weapons) {
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(new File("Weapons")));
			for (Weapon weapon : weapons) {
				writer.writeObject(weapon);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
