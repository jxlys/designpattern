package cn.test;

import cn.test.create.c2.PersonFactory;
import cn.test.entity.Person;
import cn.test.entity.PersonType;
import lombok.Data;

public class TestMain {
	public static void main(String[] args) {
		Animal a = Animal.getInstance();
		System.out.println(a);
	}
}

@Data
class Animal implements Cloneable {
	private Animal() {
		name = "1";
		p = PersonFactory.createPerson(PersonType.BAD_USER);
	}

	private String name;
	private Person p;

	static class B {
		private static Animal animal = new Animal();
	}

	public static Animal getInstance() {
		try {
			Animal b = (Animal) B.animal.clone();
			
			return b;
		} catch (CloneNotSupportedException e) {
		}
		return null;
	}
}