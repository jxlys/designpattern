package cn.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum PersonType {
	Man("man"), WUMEN("wuman");
	@Getter
	private String value;

	public static boolean isMan(PersonType srcType) {
		return srcType == Man ? true : false;
	}
}
