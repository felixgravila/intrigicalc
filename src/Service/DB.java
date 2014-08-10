package Service;

import java.util.ArrayList;
import java.util.List;
import model.Intriga;
import model.Person;

public class DB {
	
	private static DB instance = null;
	private List<Person> persons;
	private List<Intriga> intrigi;
	
	private DB(){
		if ( instance == null )
		{
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
		Person p10 = new Person ("Bratosin");
		persons.add(new Person("Felix"));
		persons.add(new Person("Reszö"));
		persons.add(new Person("Rolea"));
		persons.add(new Person("Leo"));
		persons.add(new Person("Iasmina"));
		persons.add(new Person("Adina"));
		persons.add(new Person("George"));
		persons.add(new Person("Nasuy"));
		persons.add(new Person("Nicoara"));
		persons.add(new Person ("Bratosin"));
		intrigi.add(new Intriga(p1,p2));
		intrigi.add(new Intriga(p2,p3));
		intrigi.add(new Intriga(p2,p5));
		intrigi.add(new Intriga(p7,p8));
		intrigi.add(new Intriga(p9,p10));
		}
		else
			throw new AssertionError ( );
	}

	public static DB getInstance(){
		if(instance == null)
			instance = new DB();
		return instance;
	}
	
	public List<Person> getPersons(){
		return persons;
	}
	
	public List<Intriga> getIntrigi(){
		return intrigi;
	}
	
}
