package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.annotations.InitMe;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;

public class GodFather extends MafiaWorker {

//	protected Pocket wpocket;
	
	@InitMe
	protected Pocket wpocket;
	
	protected class Pocket {

		private int value;

		public Pocket(int value) {
			this.value = value;
		} 

	}

	public GodFather() {
		super();
	}

	public GodFather(String name, String surname) {
		super(name, surname);
	}

	public GodFather(String name) {
		super(name);
	}

}
