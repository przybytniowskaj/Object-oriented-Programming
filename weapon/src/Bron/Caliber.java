package Bron;

public class Caliber implements Comparable<Caliber>{
	String value;
	String additionalValue;

	public Caliber(String string) {
		String[] caliberx = string.split(" ");
		this.value = caliberx[0];
		if (caliberx.length == 1) {
			this.additionalValue = null;
		}else {
		this.additionalValue  = caliberx[1];
		}
	}

	@Override
	public String toString() {
		return "Caliber [value=" + value + ", additionalValue=" + additionalValue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalValue == null) ? 0 : additionalValue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Caliber other = (Caliber) obj;
		if (additionalValue == null) {
			if (other.additionalValue != null)
				return false;
		} else if (!additionalValue.equals(other.additionalValue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	public int compareTo(Caliber caliber) {
		if (this.equals(caliber)){
			return 0;
		}
		else {
			return 1;
		}
		
	};
	
	
	

}
