package Threads;

public class Deamon extends Thread{
	
	public Deamon() {
		super();
		
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("I'm a deamon!!!");
		}
	}

	
	
}
