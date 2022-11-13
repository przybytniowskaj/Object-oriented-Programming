package Bron;

public class Weapon implements Comparable<Weapon>{
	String name;
	Caliber caliber;
	int serialNumber;
	double unfit;
	boolean hasFingerprints;
	
	public Weapon(String linex) {
		String[] line = linex.split(";");
		this.name = line[0];
		this.caliber = new Caliber(line[1]);
		String[] number = line[2].split(":");
		if (number.length == 2) {
			this.serialNumber = Integer.parseInt(number[1]);
		}else {
			this.serialNumber = 0;
		}
		this.unfit = Double.parseDouble(line[3].replace(",", "."));
		this.hasFingerprints = Boolean.parseBoolean(line[4]);
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", " + caliber + ", serialNumber=" + serialNumber + ", unfit=" + unfit
				+ ", hasFingerprints=" + hasFingerprints + "]";
	}
	
	@Override
	public int compareTo(Weapon o) {
		if(this.serialNumber<o.serialNumber) {
			return -1;
		}else if (this.serialNumber>o.serialNumber) {
			return 2;
		}else {
			return 1;
		}
	}

}
