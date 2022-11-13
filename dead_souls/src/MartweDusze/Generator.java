package MartweDusze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class Generator implements GeneratorIF {

	@Override
	public ArrayList<Name> readNames(File file) {
		ArrayList<Name> names = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			String x;
			while ((x = reader.readLine()) != null) {
				if (!x.matches("\s*")) {
					names.add(new Name(x));
//					System.out.println(x);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return names;
	}

	@Override
	public ArrayList<Surname> readSurnames(File file) {
		ArrayList<Surname> surnames = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), Charset.forName("ISO-8859-2")));
			String x;
			while ((x = reader.readLine()) != null) {
				if (x.matches("\\p{L}.*")) {
					surnames.add(new Surname(x));
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return surnames;
	}

	@Override
	public ArrayList<Person> generatePersons(ArrayList<Surname> surnames, ArrayList<Name> names) {
		ArrayList<Person> persons = new ArrayList<>();
		int x;
		int y;
		Random generator = new Random();
		for (int i = 0; i < 40; i++) {
			x = generator.nextInt(names.size());
//			System.out.println(names.get(x).sexName);
			y = generator.nextInt(surnames.size());
//			System.out.println(surnames.get(y).sexSurname);
			while (names.get(x).sexName != surnames.get(y).sexSurname) {
				y = generator.nextInt(surnames.size());
				System.out.println(surnames.get(y).sexSurname);
			}
			String sex = names.get(x).sexName;
			persons.add(new Person(names.get(x), surnames.get(y), sex));
		}
		return persons;
	}

	public HashMap<Integer, ArrayList<Person>> sortByAge(ArrayList<Person> generatePersons) {
		HashMap<Integer, ArrayList<Person>> map = new HashMap<Integer, ArrayList<Person>>();
		for (Person person : generatePersons) {
			int key = person.age;
			if (map.containsKey(key)) {
				map.get(key).add(person);
			} else {
				map.put(key, new ArrayList<Person>());
				map.get(key).add(person);
			}
		}
//		System.out.println(map);
		for (ArrayList<Person> list : map.values()) {
			list.sort(new PersonComparator());
		}
		return map;
	}

	public void writeSortedByAge(HashMap<Integer, ArrayList<Person>> sorted) {
		Collection<ArrayList<Person>> list = sorted.values();
		for (ArrayList<Person> peopleSameAge : list) {
//			peopleSameAge.sort(new PersonComparator());
//			Collections.sort(peopleSameAge,new PersonComparator());
			try {
//				System.out.println(peopleSameAge);
				PrintWriter writer = new PrintWriter("ludzie_" + peopleSameAge.get(0).age + ".txt", Charset.forName("Cp1250"));
				for (int i = 0; i<peopleSameAge.size(); i++) {
					writer.write(peopleSameAge.get(i).toString() + System.lineSeparator());

				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void serialize(ArrayList<Person> people) {
		System.out.println("Serializacja: ");
		try {
			File file = new File("People.dat");
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
			for (Person person : people) {
				writer.writeObject(person);
				System.out.println(person);
			}
			writer.writeObject(null);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Object> deserialize(File file) {
		System.out.println("Deserializacja: ");
		ArrayList<Object> objectsList = new ArrayList<>();
        	try {
        		ObjectInputStream read = new ObjectInputStream(new FileInputStream(file));
            	Object object = read.readObject();
            	while (object != null) {
            		System.out.println(object);
                    objectsList.add(object);
                    object = read.readObject();
            	}
            	read.close();
			}catch (ClassNotFoundException f) {
				f.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
        return objectsList;
	}
	
	
	
}
