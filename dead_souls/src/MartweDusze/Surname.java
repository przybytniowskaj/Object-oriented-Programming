package MartweDusze;

import java.io.Serializable;
import java.util.Scanner;

public class Surname implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2490438551575157392L;
	public String surname;
	public double surnamePopularity;
	public String sexSurname;

	public Surname(String surnameLine) {
//		String surname = surnameLine.replace("+", ";");
//		System.out.println(surname);
//		String surnameLine2 = surname.replace("-", ";");
//		System.out.println(surnameLine2);
		
		Scanner scanner = new Scanner(surnameLine).useDelimiter(";");
		this.surname = scanner.next();
//		System.out.println(this.surname);
		String popularity = scanner.next().replace(",", ".");
		this.surnamePopularity = Double.parseDouble(popularity);
		if (surname.substring(surname.length() - 1).equals("a")) {
			this.sexSurname = "female";
		} else {
			this.sexSurname = "male";
		}
		scanner.close();
	}

	@Override
	public String toString() {
		return "Surname [surname=" + surname + ", surnamePopularity=" + surnamePopularity + "]";
	}

}
