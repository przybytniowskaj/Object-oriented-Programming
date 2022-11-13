package Lab_oceniany_3;

import java.util.Scanner;

public class Pacjent {
	protected int id;
	protected String plec;
	protected int wiek;
	protected double temp;
	protected boolean kaszel;
	protected boolean covid;
	protected String x;

	public Pacjent(String line) {
		Scanner scanner = new Scanner(line).useDelimiter("#");
		this.id = Integer.parseInt(scanner.next());
		this.plec = scanner.next();
		this.wiek = Integer.parseInt(scanner.next());
		this.temp = Double.parseDouble(scanner.next());
		this.kaszel = Boolean.parseBoolean(scanner.next());
		this.x = scanner.next();
		this.covid = Boolean.parseBoolean(scanner.next());
		scanner.close();

	}

	@Override
	public String toString() {
		return "Pacjent [id=" + id + ", plec=" + plec + ", wiek=" + wiek + ", temp=" + temp + ", kaszel=" + kaszel
				+ ", covid=" + covid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (covid ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (kaszel ? 1231 : 1237);
		result = prime * result + ((plec == null) ? 0 : plec.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this.temp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + wiek;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacjent other = (Pacjent) obj;
		if (covid != other.covid)
			return false;
		if (id != other.id)
			return false;
		if (kaszel != other.kaszel)
			return false;
		if (plec == null) {
			if (other.plec != null)
				return false;
		} else if (!plec.equals(other.plec))
			return false;
		if (Double.doubleToLongBits(temp) != Double.doubleToLongBits(other.temp))
			return false;
		if (wiek != other.wiek)
			return false;
		return true;
	}

}
