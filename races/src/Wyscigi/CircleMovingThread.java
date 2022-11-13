package Wyscigi;


public class CircleMovingThread extends Thread{
	
	private Demonstrator demonstrator;
	private DrawPanel drawPanel;
	private int sleep;
	
	
	public CircleMovingThread(DrawPanel drawPanel, int sleep, Demonstrator demonstrator) {
		super();
		this.demonstrator = demonstrator;
		this.drawPanel = drawPanel;
		this.sleep = sleep;
	}


	@Override
	public void run() {
		demonstrator.moveCircle(drawPanel, sleep);
	}

}
