package graphql.backend.bakery.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Bread {

	@Setter
	private Integer id;

	private String name;

	private Integer bakeTime;

	private List<FlourType> flourTypes;

	private ExtraIngredients extraIngredients;

	private Bakery bakery;

	public Bread (String name) {
		this.name = name;
	}

	public Bread(int id, String name, Integer bakeTime, List<FlourType> flourTypes, ExtraIngredients extraIngredients) {
		this(name);
		this.id = id;
		this.bakeTime = bakeTime;
		this.flourTypes = flourTypes;
		this.extraIngredients = extraIngredients;
	}

	public String getBigName() {
		return "big " + name;
	}
}
