package MartweDusze;

import java.io.Serializable;
import java.util.Random;

public class Person implements Serializable, Comparable<Person> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 580735531559866837L;
	public final Name name;
	public final Surname surname;
	public final String sex;
	public final int age;

	public Person(Name name, Surname surname, String sex) {
		super();
		this.name = name;
		this.surname = surname;
		int age = new Random().nextInt(8) + 18;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [" + name + ", " + surname + ", sex=" + sex + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		if (this.age == o.age) {
			return 1;
		} else if (this.age < o.age) {
			return -1;
		} else {
			return 2;
		}

	}
	
	

}
