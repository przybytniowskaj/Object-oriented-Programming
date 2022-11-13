package ReverseEngineering2;

public class ThreadWait extends Thread {

	private DrawingPanel panel;
	private Figure figure;

	public ThreadWait(DrawingPanel panel, Figure figure) {
		this.panel = panel;
		this.figure = figure;
	}

	public void run() {
		panel.waiting(figure);
	}

}
