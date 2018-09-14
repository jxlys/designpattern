package cn.test.create.c3;

public class C {

	private C() {
	}

	// 使用的时候加载
	private static class CFactory {
		private static C c = new C();
	}

	public static C getInstance() {
		return CFactory.c;
	}
}
