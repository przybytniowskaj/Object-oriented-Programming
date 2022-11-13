package pl.edu.pw.mini.zpoif.task5.machine;

import pl.edu.pw.mini.zpoif.task5.annotations.DoIt;
import pl.edu.pw.mini.zpoif.task5.annotations.InitMe;
import pl.edu.pw.mini.zpoif.task5.annotations.MafiaValidator;
import pl.edu.pw.mini.zpoif.task5.annotations.MyAnnotation;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.general.IllegalSeller;
import pl.edu.pw.mini.zpoif.task5.people.general.LegalSeller;
import pl.edu.pw.mini.zpoif.task5.people.general.Seller;
import pl.edu.pw.mini.zpoif.task5.people.special.Accountant;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;
import pl.edu.pw.mini.zpoif.task5.people.special.Recruiter;

import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;

public class MyMachine extends MafiaMachine {

    @Override
    protected Set<MafiaWorker> createImportantMafiaWorkers() {
        return null;
    }

    @Override
    protected MafiaWorker createPrimaryMafiaWorker() throws MafiaException {
      return null;
    }

    @Override
    protected MafiaWorker createPrioritizedPrimaryMafiaWorker() {
        return null;
    }
    
    @Override
    protected void fillFields(Set<MafiaWorker> workers) {
    	// TODO Auto-generated method stub
    	
    }


    @Override
    protected ButtonMan getKiller(String name, String surname) throws MafiaException{
//        zaimplementuje metodê getKiller(String name, String surname) klasy
//        MafiaMachine, która instancjonuje zabójcê w ten sposób ¿e przekazuje do jego
//        konstruktora parametry name i surname. Jeœli znajdzie na którymœ z parametrów
//        adnotacjê MaxLength to sprawdza czy iloœc znaków mieœci siê w dopuszczalnym
//        zakresie okreœlonym parametrami adnotacji. Jeœli nie, to wyrzuca wyj¹tek
//        MafiaException.
        ButtonMan buttonMan = new ButtonMan(name, surname);
        Parameter[] parameters = ButtonMan.class.getConstructor(String.class, String.class).getParameters();
        for (Parameter parameter: parameters){
            if (parameter.isAnnotationPresent(MafiaValidator.class)){
                if (parameter.getName().length() > MafiaValidator.class){
                    throw new MafiaException();
                }
            }
        }
    }

    @Override
    protected void init(MafiaWorker mafiaWorker){
        Field[] fields = mafiaWorker.getClass().getFields();
        for (Field field: fields){
            if(field.isAnnotationPresent(InitMe.class)){
                Class szukanaKlasa = field.getType().getClass();
                field.set(szukanaKlasa.newInstance());
            }
        }

    }

    @Override
    protected void goButtonMan(Set<MafiaWorker> buttonMan) {
        Class<?> klasa = buttonMan.getClass();
        Method[] metodyKlasy = klasa.getMethods();
        try {
        for (Method method : metodyKlasy) {
            if (method.isAnnotationPresent(DoIt.class)){
                DoIt doIt = (DoIt) method.getAnnotation(DoIt.class);
                for (int i = 0; i < doIt.times(); i++) {
                	Random rand = new Random();
                	int str = rand.nextInt(3);
                	if (str == 0) {
                		Field field = klasa.getField("firstVictim");
                		field.setAccessible(true);
                		method.invoke(field.get(klasa));
                	}else if (str ==1) {
                		Field field = klasa.getField("secondVictim");
                		field.setAccessible(true);
                		method.invoke(field.get(klasa));
                	}else {
                		Field field = klasa.getField("thirdVictim");
                		field.setAccessible(true);
                		method.invoke(field.get(klasa));
                	}
                    
                }
            }
        }}catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    @Override
    protected void retreat(ButtonMan buttonMan) {
    	Method[] metody = ButtonMan.class.getMethods();
        for (Method metoda: metody){
            if (metoda.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation myAnnotation = (MyAnnotation) metoda.getAnnotation(MyAnnotation.class);
                for (int i = 0; i < myAnnotation.cokolwiek(); i++) {
                    System.out.println("Method " + metoda + " has addnotation called 'Mine'.");
                }
            }
        }
    	
    }
    
    
    protected void myZadanko(ButtonMan buttonMan){
        Method[] metody = ButtonMan.class.getMethods();
        for (Method metoda: metody){
            if (metoda.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation myAnnotation = (MyAnnotation) metoda.getAnnotation(MyAnnotation.class);
                for (int i = 0; i < myAnnotation.cokolwiek(); i++) {
                    System.out.println("Metoda " + metoda + " posiada adnotacjê MyAnnotation.");
                }
            }
        }
    }

    
}
