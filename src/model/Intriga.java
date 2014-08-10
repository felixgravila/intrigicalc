package model;

public class Intriga {
	private Person p1;
	private Person p2;
	
	public Intriga(Person p1, Person p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Person getP1() {
		return p1;
	}
	public Person getP2() {
		return p2;
	}
	
	@Override
	public String toString() {
		return ""+p1+" - "+p2;
	}
}
