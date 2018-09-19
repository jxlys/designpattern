package cn.test.creational.c3;

/**
 * 饿汉式
 * @author Administrator
 *
 */
public class A {
	private static A a = new A();

	private A() {
	}

	public static A getInstance() {
		return a;
	}
}

