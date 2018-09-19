package cn.test.creational.c2;

import java.util.Arrays;

import cn.test.entity.BadUser;
import cn.test.entity.GoodUser;
import cn.test.entity.Person;
import cn.test.entity.PersonType;

//生产工厂(好坏)
public class StateFactory extends PersonFactory {

	private static PersonFactory stateFactory = new StateFactory();
	private PersonType[] types = new PersonType[] { PersonType.GOOD_USER, PersonType.BAD_USER };

	public Person createNewPerson(PersonType type) {
		switch (type) {
		case GOOD_USER:
			return new GoodUser();
		case BAD_USER:
			return new BadUser();
		default:
			return null;
		}
	}

	public boolean contain(PersonType type) {
		return Arrays.asList(types).contains(type);
	}

	public static PersonFactory getInstance() {
		return stateFactory;
	}
}
