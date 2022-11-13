package ReverseEngineering2;

public class ThreadXY extends Thread {

	private DrawingPanel panel;
	private Figure figure;

	public ThreadXY(DrawingPanel panel, Figure figure) {
		this.panel = panel;
		this.figure = figure;
	}

	public void run() {
		panel.moving(figure);
	}

}
