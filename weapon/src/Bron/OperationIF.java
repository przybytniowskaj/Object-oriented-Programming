package Bron;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface OperationIF {
	
	public ArrayList<Weapon> readLines(File file);
	public HashMap<Caliber, ArrayList<Weapon>> getSortedWeapon(ArrayList<Weapon> listOfWeapon);
	public void writeSortedWeapon(HashMap<Caliber, ArrayList<Weapon>> sortedWeapon);
	public void serialise(ArrayList<Weapon> weapons);
	
}
