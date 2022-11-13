package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.annotations.FillIfEmptyIt;
import pl.edu.pw.mini.zpoif.task5.annotations.ImportantWorker;
import pl.edu.pw.mini.zpoif.task5.annotations.PrimaryMafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;

@ImportantWorker(quantity = 3)
@PrimaryMafiaWorker
public class Accountant extends MafiaWorker {
	
	@FillIfEmptyIt
	protected String secondName;
	protected String school;
	
	public Accountant() {
		super();
	}

	public Accountant(String name, String surname) {
		super(name, surname);
	}

	public Accountant(String name) {
		super(name);
	}

}
