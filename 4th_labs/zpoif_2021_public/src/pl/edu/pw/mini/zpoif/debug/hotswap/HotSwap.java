package pl.edu.pw.mini.zpoif.debug.hotswap;

public class HotSwap {

	public static void main(String[] args) {
		HotSwap hotSwap = new HotSwap();
		hotSwap.go();
	}

	private void go() {
		Tool tool = new Tool();
		boolean flag = true;
		try {
			while (flag) {
				Thread.sleep(2000);
				tool.doSth();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
