package MartweDusze;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Demonstrator {

	public static void main(String[] args) {
		File nameFile = new File("imiona.txt");
		Generator generator = new Generator();
		ArrayList<Name> names = generator.readNames(nameFile);
		File surnameFile = new File("nazwiska.txt");
		ArrayList<Surname> surnames = generator.readSurnames(surnameFile);
//		System.out.println(names);
//		System.out.println(surnames);
		ArrayList<Person> persons = generator.generatePersons(surnames, names);
//		for(int i = 0; i<10; i++) {
//			System.out.println(persons.get(i));
//		}
		HashMap<Integer, ArrayList<Person>> sorted = generator.sortByAge(persons);
//		for(Map.Entry<Integer, ArrayList<Person>> entry : sorted.entrySet()) {
//			System.out.println(entry.getKey());
//		}
		generator.writeSortedByAge(sorted);
//		generator.serialize(persons);
//		generator.deserialize(new File("People.dat"));
	}

}
