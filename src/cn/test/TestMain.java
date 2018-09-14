package cn.test;

import cn.test.create.c2.PersonFactory;
import cn.test.entity.PersonType;

public class TestMain {
	public static void main(String[] args) {
		System.out.println(PersonFactory.createPerson(PersonType.MAN));

	}
}
