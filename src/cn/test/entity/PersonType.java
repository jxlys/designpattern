package cn.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum PersonType {
	MAN("man"), WUMEN("wuman"), GOOD_USER("good"), BAD_USER("bad");
	@Getter
	private String value;

	public static boolean isMan(PersonType srcType) {
		return srcType == MAN ? true : false;
	}
}
