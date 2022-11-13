package pl.edu.pw.mini.zpoif.task4b.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.edu.pw.mini.zpoif.task4b.building.Budka;
import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;
import java.lang.reflect.*;

public class Rozwiazanie extends Solution {

	public void demonstrate() {
		try {
			Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
			WygodnaBudka budka = (WygodnaBudka) klasa.newInstance();
			task1();
			task2(budka);
			task3(budka);
			task4(budka);
			task5();
			System.out.println(task6());
			task7(budka);
			task8();
			System.out.println(task9());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected WygodnaBudka task1() throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Constructor<WygodnaBudka> konstruktor_room = klasa.getConstructor();
		WygodnaBudka room = konstruktor_room.newInstance();
		return room;
	}

	@Override
	protected void task2(WygodnaBudka wygodnaBudka) throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Field napis = klasa.getDeclaredField("napisNaScianie");
		napis.setAccessible(true);
		System.out.println("Pole napisNaScianie: " + napis.get(wygodnaBudka));
	}

	@Override
	protected void task3(WygodnaBudka wygodnaBudka) throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Class klasa2 = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.Budka");
		
		Field szyfr = klasa.getDeclaredField("szyfrDoSejfu");
		szyfr.setAccessible(true);
		Field uSzyfr = klasa2.getDeclaredField("UNIWERSALNY_SZYFR_DO_SEJFU");
		uSzyfr.setAccessible(true);
		szyfr.set(wygodnaBudka, uSzyfr.get(wygodnaBudka));
	}

	@Override
	protected void task4(WygodnaBudka wygodnaBudka) throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Method[] metody = klasa.getMethods();
		for (Method m : metody) {
			if (m.getParameters().length == 0 & m.getReturnType() == String.class) {
				System.out.println("task4");
				System.out.println(m.getName());
				System.out.println(m.invoke(wygodnaBudka));
			}
		}

	}

	@Override
	protected void task5() throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Field wersalka = klasa.getDeclaredField("wersalka");
		wersalka.setAccessible(true);
		Class klasaWersalki = wersalka.getType();
		System.out.println(klasaWersalki.getSimpleName());
		Class superclass = klasaWersalki.getSuperclass();
		while (superclass != null) {
			String className = superclass.getSimpleName();
			System.out.println(className);
			superclass = superclass.getSuperclass();
		}
	}

	@Override
	protected WygodnaBudka task6() throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Constructor[] konstruktory = klasa.getConstructors();
		for (Constructor c : konstruktory) {
			if (c.getParameters().length == 2 & c.getParameters()[0].getType() == String.class
					& c.getParameters()[1].getType() == String.class) {
				WygodnaBudka budka = (WygodnaBudka) c.newInstance("Best", "Meble i s-ka");
				return budka;
			}
		}
		return null;
	}

	@Override
	protected void task7(WygodnaBudka wygodnaBudka) throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Class[] klasy = klasa.getDeclaredClasses();
		for (Class c : klasy) {

		}
	}

	@Override
	protected void task8() throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Class nadklasa = klasa.getSuperclass();
		Class[] klasyWew = nadklasa.getDeclaredClasses();
		for (Class k : klasyWew) {
			if (Modifier.isProtected(k.getModifiers())) {
				System.out.println(k.getSimpleName());
			}
		}
	}

	@Override
	protected List<String> task9() throws Exception {
		Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Class klasa2 = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.Budka");
		List<String> result = new ArrayList<String>();
		Method[] metodyW = klasa.getMethods();
		Method[] metodyB = klasa2.getDeclaredMethods();
		ArrayList<Method> metody = new ArrayList<>(Arrays.asList(metodyW));
		ArrayList<Method> metody2 = new ArrayList<>(Arrays.asList(metodyB));
		for (Method m : metody) {
			if (!metody2.contains(m)) {
				result.add(m.getName());
			}
		}

		return result;
	}

}
