package Threads;

public class MyFirstThread extends Thread{
	
	private final int k;
	private final String msg;
	private final int p;
	
	public MyFirstThread(int p, int k, String msg) {
		super();
		this.p = p;
		this.k = k;
		this.msg = msg;
	}
	
	public void start() {
		try {
			for (int i = 0; i<k; i++) {
				System.out.println(msg);
				sleep(p*1000);
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
}
