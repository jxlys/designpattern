package cn.test.structural;

import cn.test.stru_entity.LeftWalk;

public class TestMain {
	public static void main(String[] args) {
		A a = new A(new LeftWalk());
		a.walk();
	}
}


