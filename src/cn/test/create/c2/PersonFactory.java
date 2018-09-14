package cn.test.create.c2;

import cn.test.entity.Person;
import cn.test.entity.PersonType;

//抽象工厂
public abstract class PersonFactory {
	private static PersonFactory personFactory;

	// 根据类型
	abstract Person createNewPerson(PersonType type);

	// 检测是否包含这个类型
	abstract boolean contain(PersonType type);

	// 访问方法，根本不会具体访问工厂的底层
	public static Person createPerson(PersonType type) {
		personFactory = SexFactory.getInstance();
		if (personFactory.contain(type)) {
			return personFactory.createNewPerson(type);
		}
		personFactory = StateFactory.getInstance();
		if (personFactory.contain(type)) {
			return personFactory.createNewPerson(type);
		}
		return null;
	}
}
