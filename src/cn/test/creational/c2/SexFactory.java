package cn.test.creational.c2;

import java.util.Arrays;

import cn.test.entity.Man;
import cn.test.entity.Person;
import cn.test.entity.PersonType;
import cn.test.entity.Wuman;

//生产工厂(男女)
public class SexFactory extends PersonFactory {
	private static PersonFactory sexFactory = new SexFactory();
	private PersonType[] types = new PersonType[] { PersonType.MAN, PersonType.WUMEN };

	// 性别来创建
	public Person createNewPerson(PersonType type) {
		switch (type) {
		case MAN:
			return new Man();
		case WUMEN:
			return new Wuman();
		default:
			return null;
		}
	}

	public boolean contain(PersonType type) {
		return Arrays.asList(types).contains(type);
	}

	public static PersonFactory getInstance() {
		return sexFactory;
	}

}
