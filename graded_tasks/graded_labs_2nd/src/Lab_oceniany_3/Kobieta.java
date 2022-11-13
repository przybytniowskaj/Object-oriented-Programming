package Lab_oceniany_3;

import java.util.Scanner;

public class Kobieta extends Pacjent {
	protected String nazwisko;

	public Kobieta(String line) {
		super(line);
		Scanner scanner = new Scanner(line).useDelimiter("#");
		for (int i = 0; i < 6; i++) {
			scanner.next();
		}
		this.nazwisko = scanner.next();
		scanner.close();
	}

	@Override
	public String toString() {
		return "Kobieta [id= " + id + ", plec=" + plec + ", wiek=" + wiek + ", temperatura=" + temp + ", kaszel= "
				+ kaszel + " nazwiskoRodowe= " + nazwisko + ", covid=" + covid + "]";
	}

}
