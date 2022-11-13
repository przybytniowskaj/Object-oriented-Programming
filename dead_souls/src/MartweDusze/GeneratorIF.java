package MartweDusze;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface GeneratorIF {
	
	public ArrayList<Name> readNames(File file);
	public ArrayList<Surname> readSurnames(File file);
	public ArrayList<Person> generatePersons(ArrayList<Surname> surnames, ArrayList<Name> names);
	public HashMap<Integer, ArrayList<Person>> sortByAge(ArrayList<Person> generatePersons);
	public void writeSortedByAge(HashMap<Integer, ArrayList<Person>> sorted);
	public void serialize(ArrayList<Person> people);
	public ArrayList<Object> deserialize(File file);
	
}
