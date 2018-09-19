package cn.test.creational.c4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.test.creational.c2.PersonFactory;
import cn.test.entity.Person;
import cn.test.entity.PersonType;

//建造者模式
public class PersonBuilder {
	List<Person> list = new ArrayList<Person>();

	public void addMan() {
		PersonType[] types = new PersonType[] { PersonType.MAN, PersonType.WUMEN, PersonType.GOOD_USER, PersonType.BAD_USER };
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(PersonFactory.createPerson(types[r.nextInt(4)]));
		}
		for (Person p : list) {
			System.out.println(p);
		}
	}
}
