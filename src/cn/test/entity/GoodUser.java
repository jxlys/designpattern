package cn.test.entity;

public class GoodUser extends Person {
	public GoodUser() {
		setAge(30);
		setName(PersonType.Man.getValue());
		setMoney("1000");
		setType("Good");
	}
}
