package Lab_oceniany_3;

import java.util.Scanner;

public class Mezczyzna extends Pacjent{
	protected Boolean czyWojsko;
	
	public Mezczyzna(String line) {
		super(line);
		Scanner scanner = new Scanner(line).useDelimiter("#");
		for (int i = 0; i< 6; i++) {
			scanner.next();
		}
		this.czyWojsko = Boolean.parseBoolean(scanner.next());
		scanner.close();
	}

	@Override
	public String toString() {
		return "Mezczyzna [id= " + id + ", plec=" + plec + ", wiek=" + wiek + ", temp=" + temp + ", kaszel=" + kaszel
				+ " czyWojsko=" + czyWojsko + ", covid=" + covid + "]";
	}

	
	
}
