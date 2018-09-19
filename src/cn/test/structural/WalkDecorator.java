package cn.test.structural;

import cn.test.stru_entity.Walk;
import lombok.Getter;
import lombok.Setter;

public class WalkDecorator implements Walk {

	public void wolk() {
	}

}
@Getter
@Setter
class A {

	private Walk walk;

	public void action() {
		walk.wolk();
	}

	private A() {
	}

	public static A getInstance() {
		return Aprototype.a;
	}

	private static class Aprototype {
		private static A a = new A();
	}
}