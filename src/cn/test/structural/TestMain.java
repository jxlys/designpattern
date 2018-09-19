package cn.test.structural;

import cn.test.stru_entity.LeftWalk;

public class TestMain {
	public static void main(String[] args) {
		A a = A.getInstance();
		a.setWalk(new LeftWalk());
		a.action();
	}
}


