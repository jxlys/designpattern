package cn.test.entity;

public class Wuman extends Person {
	public Wuman() {
		setAge(16);
		setSex(PersonType.WUMEN);
		setName(PersonType.WUMEN.getValue());
		setMoney("2000");
	}
}
