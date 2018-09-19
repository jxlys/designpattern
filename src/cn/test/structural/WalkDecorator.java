package cn.test.structural;

import cn.test.stru_entity.Walk;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WalkDecorator implements Walk {
	private Walk walk;
	public void walk() {
		walk.walk();
	}
}
class A extends WalkDecorator {
	public A(Walk walk) {
		super(walk);
	}
}