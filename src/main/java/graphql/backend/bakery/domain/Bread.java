package graphql.backend.bakery.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Bread {

	private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(100);

	private int id;

	private String name;

	private Integer bakeTime;

	private List<FlourType> flourTypes;

	private ExtraIngredients extraIngredients;

	private Bakery bakery;

	public Bread (String name) {
		id = ID_SEQUENCE.incrementAndGet();
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
