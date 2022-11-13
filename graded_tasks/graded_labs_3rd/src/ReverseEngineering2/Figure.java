package ReverseEngineering2;

public class Figure {
	private int x, y;

	public Figure(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "figure[" + getX() + ", " + getY() + "]";

	}

}
