package graphql.backend.bakery.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Bread {

	private final int id;

	private final String name;

	private final Integer bakeTime;

	private final List<FlourType> flourTypes;

	private final ExtraIngredients extraIngredients;

	private Bakery bakery;
}
