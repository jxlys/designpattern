package cn.test.create.c1;

import cn.test.entity.*;

//静态工厂类
public class PersonFactory {

	/**
	 * 对象创建对象
	 */
	public static Person newDefaultUser(PersonType srcPerson) {
		Person targetPerson = null;
		switch (srcPerson) {
		case MAN:
			targetPerson = new Man();
			break;
		case WUMEN:
			targetPerson = new Wuman();
			break;
		default:
			break;
		}
		return targetPerson;
	}
}
