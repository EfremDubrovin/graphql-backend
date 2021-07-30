package graphql.backend.bakery.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class ExtraIngredients {

	private final List<String> extraIngredients;

	private final String proportions;
}
