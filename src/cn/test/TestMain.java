package cn.test;

import cn.test.create.c1.PersonFactory;
import cn.test.entity.Person;
import cn.test.entity.PersonType;

public class TestMain {
	public static void main(String[] args) {

		Person person = PersonFactory.newDefaultUser(PersonType.WUMEN);

		System.out.println(person);
	}
}
