package cn.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Person {
	private String name;
	private PersonType sex;
	private String type;
	private Integer age;
	private String money;

}
