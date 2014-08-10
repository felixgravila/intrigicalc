package Service;

import java.util.ArrayList;

import model.Intriga;
import model.Person;

public class DB {
	
	private static DB instance = null;
	
	private ArrayList<Person> persons;
	private ArrayList<Intriga> intrigi;
	
	private DB(){
		persons = new ArrayList<>();
		intrigi = new ArrayList<>();
		Person p1 = new Person("Felix");
		Person p2 = new Person("Reszö");
		Person p3 = new Person("Rolea");
		Person p4 = new Person("Leo");
		Person p5 = new Person("Iasmina");
		Person p6 = new Person("Adina");
		Person p7 = new Person("George");
		Person p8 = new Person("Nasuy");
		Person p9 = new Person("Nicoara");
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);
		persons.add(p6);
		persons.add(p7);
		persons.add(p8);
		persons.add(p9);
		intrigi.add(new Intriga(p1,p2));
		intrigi.add(new Intriga(p2,p3));
		intrigi.add(new Intriga(p2,p5));
		intrigi.add(new Intriga(p7,p8));
	}

	public static DB getInstance(){
		if(instance == null)
			instance = new DB();
		return instance;
	}
	
	public ArrayList<Person> getPersons(){
		return persons;
	}
	
	public ArrayList<Intriga> getIntrigi(){
		return intrigi;
	}
	
}
