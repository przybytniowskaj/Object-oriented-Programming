package MartweDusze;

import java.io.Serializable;
import java.util.Scanner;

public class Name implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6427674120957715788L;
	public String firstName;
	public String secondName = null;
	public String sexName;

	public Name(String nameLine) {
		super();
		Scanner scanner = new Scanner(nameLine).useDelimiter(" ");
		this.firstName = scanner.next();
		if (scanner.hasNext() == true) {
			this.secondName = scanner.next();
		}
//		System.out.println(firstName.substring(firstName.length() - 1));
//		System.out.println(firstName);
		if (firstName.substring(firstName.length() - 1).equals("a")) {
			this.sexName = "female";
		} else {
			this.sexName = "male";
		}
		scanner.close();
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", secondName=" + secondName + "]";
	}
	
	

}
