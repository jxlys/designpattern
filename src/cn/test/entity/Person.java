package cn.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
	private String name;
	private PersonType sex;
	private Integer age;
	private String money;

}
