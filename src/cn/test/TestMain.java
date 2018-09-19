package cn.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TestMain {
	public static void main(String[] args) {
		Animal a = Animal.getInstance();
		System.out.println(a);
		Animal b = Animal.getInstance();
		System.out.println(b);
		System.out.println();

		b.getB().value = "2";
		System.out.println(a);
		System.out.println(b);
	}
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class B {
	String value;
}

@Data
class Animal implements Cloneable {

	private B b;

	static class C {
		private static Animal animal = new Animal() {
			{
				setB(new B("1"));
			}
		};
	}

	public static Animal getInstance() {
		try {
			Animal b = (Animal) C.animal.clone();
			return b;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}