package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.annotations.DoIt;
import pl.edu.pw.mini.zpoif.task5.annotations.MafiaValidator;
import pl.edu.pw.mini.zpoif.task5.annotations.Mine;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;

public class ButtonMan extends MafiaWorker {

	protected String firstVictim = "John D.";
	protected String secondVictim = "Matt Cooper";
	protected String thirdVictim = "Unknown";

	public ButtonMan() {
		super();
	}

	public ButtonMan(@MafiaValidator String name, String surname) {
		super(name, surname);
	}

	public ButtonMan(@MafiaValidator String name) {
		super(name);
	}

	public void killHim(String value) {
		System.out.println(value + " has been killed!");
	}

	public void killThemAll(String value) {
		System.out.println(value + " also killed");
	}

	@DoIt(times = 4)
	public void killHim() {
		System.out.println("Killed!");
	}

	@DoIt(times = 7)
	public void killThemAll() {
		System.out.println("Done!");
	}
	
	@Mine
	public void kill() {
		System.out.println("Works!");
	}
	
}
