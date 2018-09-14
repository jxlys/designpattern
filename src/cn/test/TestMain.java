package cn.test;

import cn.test.create.PersonFactory;
import cn.test.entity.Person;
import cn.test.entity.PersonType;

public class TestMain {
	public static void main(String[] args) {

		Person person = PersonFactory.newDefaultUser(PersonType.Man);

		System.out.println(person);
	}
}
