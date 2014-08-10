package Service;

import java.util.List;
import model.Intriga;
import model.Person;

public class Service {
	
	private static Service instance = null;
	List<Person> people = DB.getInstance().getPersons();
	Person peopleArr[] = new Person[people.size()+1];
	
	private Service(){
		if ( instance != null )
			throw new AssertionError ( );
	}
	
	public static Service getInstance(){
		if(instance == null)
			instance = new Service();
		return instance;
	}
	
	public Person[] getTheThing(){
		if(back(1))
			return peopleArr;
		return null;
	}
	
	
	private boolean back(int pos){
		if(pos==people.size()+1)
			return verify();
		for(Person p:people){
			peopleArr[pos] = p;
			if(back(pos+1))
				return true;
		}
		return false;
	}
	
	
	
	private boolean verify(){
		int i,j;
		for(i=1;i<people.size();i++)
			if(existsIntriga(peopleArr[i],peopleArr[i+1]))
				return false;
		for(i=1;i<people.size();i++)
			for(j=i+1;j<=people.size();j++)
				if(peopleArr[i].equals(peopleArr[j]))
					return false;
		
		return true;
	}
	
	public boolean existsIntriga(Person p1, Person p2){
    	for(Intriga i:DB.getInstance().getIntrigi()){
    		if(i.getP1().equals(p1) && i.getP2().equals(p2))
    			return true;
    		if(i.getP1().equals(p2) && i.getP2().equals(p1))
    			return true;
    	}
    	return false;
    }

}
