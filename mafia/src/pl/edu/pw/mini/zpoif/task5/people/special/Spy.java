package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.annotations.PrimaryMafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;

@PrimaryMafiaWorker(prority = 3)
public class Spy extends MafiaWorker {

	public Spy() {
		super();
	}

	public Spy(String name, String surname) {
		super(name, surname);
	}

	public Spy(String name) {
		super(name);
	}

}
