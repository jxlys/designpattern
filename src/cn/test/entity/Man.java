package cn.test.entity;

public class Man extends Person {
	public Man() {
		setAge(18);
		setSex(PersonType.Man);
		setName(PersonType.Man.getValue());
		setMoney("1000");
	}
}
