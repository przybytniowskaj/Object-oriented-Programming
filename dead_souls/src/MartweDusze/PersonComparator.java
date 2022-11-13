package MartweDusze;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.surname.surname.compareTo(o2.surname.surname) == 0) {
			return o1.name.firstName.compareTo(o2.name.firstName);
		}else {
			return o1.surname.surname.compareTo(o1.surname.surname);
		}
	}
	
}
