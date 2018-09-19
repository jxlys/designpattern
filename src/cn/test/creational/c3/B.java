package cn.test.creational.c3;

//懒汉式
public class B {
	private static B b;

	public static B getInstance() {
		if (b == null) {
			// 这里能同时进来两个线程
			synchronized (b) {
				// 这里只能进来一个线程
				if (b == null) {
					b = new B();
				}
			}
		}
		return b;
	}

	private B() {
	}
}
