package kr.namoosori.helloplugin.jface.tableviewer;

public class Person {
	//
	public String firstName;
	public String lastName;
	public int age;
	public Person[] children = new Person[0];
	public Person parent;

	public Person(String firstName, String lastName, int age) {
		//
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Person(String firstName, String lastName, int age, Person[] children) {
		//
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.children = children;
		for (int i = 0; i < children.length; i++) {
			children[i].parent = this;
		}
	}

	public static Person[] example() {
		//
		return new Person[] {
				new Person("Dan", "Ruble", 41, new Person[] { 
						new Person("Beth", "Rubel", 6) }),
				new Person("Eric", "Clayberg", 42, new Person[] {
						new Person("Lauren", "Clayberg", 9),
						new Person("Lee", "Clayberg", 7) }),
				new Person("Mike", "Taylor", 55) };
	}

}
