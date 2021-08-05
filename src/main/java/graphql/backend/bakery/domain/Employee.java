package graphql.backend.bakery.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Employee {

	@Setter
	private Integer id;
	private String name;
	private int age;
	private String personalInfo;

	public Employee(String name, int age, String personalInfo) {
		this.name = name;
		this.age = age;
		this.personalInfo = personalInfo;
	}
}
