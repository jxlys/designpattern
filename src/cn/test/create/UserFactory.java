package cn.test.create;

import cn.test.entity.*;

//Factory
//静态工厂类
public class UserFactory {

	/**
	 * 对象创建对象
	 */
	public static Person newDefaultUser(PersonType srcPerson) {
		Person targetPerson = null;
		switch (srcPerson) {
		case Man:
			targetPerson = new Man();
			break;
		case WUMEN:
			targetPerson = new Wuman();
			break;
		}
		return targetPerson;
	}
}
