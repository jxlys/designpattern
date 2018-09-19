package cn.test.structural;

import cn.test.stru_entity.LeftWalk;
import cn.test.stru_entity.RightWalk;
import cn.test.stru_entity.Walk;

public class WalkFacade implements Walk {

	public void wolk() {
		WalkFacadeSingleton.left.wolk();
		WalkFacadeSingleton.right.wolk();
	}

	public static Walk getInstance() {
		return WalkFacadeSingleton.facade;
	}

	private WalkFacade() {
	}

	private static class WalkFacadeSingleton {
		private static Walk facade = new WalkFacade();
		private static Walk left = new LeftWalk();
		private static Walk right = new RightWalk();
		
	}
}
