package cn.test.entity;

public class BadUser extends Person {
	public BadUser() {
		setAge(29);
		setName(PersonType.MAN.getValue());
		setMoney("1000");
		setType("Bad");
	}
}
