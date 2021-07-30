package graphql.backend.bakery;

import graphql.backend.bakery.domain.ExtraIngredients;
import graphql.schema.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class CustomScalars {

	public static final GraphQLScalarType EXTRA_INGREDIENTS = GraphQLScalarType.newScalar()
		.name("ExtraIngredients")
		.description("Something we add to the bread like olives, cheese, fruits, chocolate etc.")
		.coercing(new Coercing<ExtraIngredients, Map<String, String>>() {
			@Override
			public Map<String, String> serialize(Object dataFetcherResult) throws CoercingSerializeException {
				if (dataFetcherResult instanceof ExtraIngredients) {
					ExtraIngredients extra = (ExtraIngredients) dataFetcherResult;
					String joinedExtraIngredients = String.join(",", extra.getExtraIngredients());
					Map<String, String> customRepresentation = new HashMap<>();
					customRepresentation.put("ingredientsList", joinedExtraIngredients);
					customRepresentation.put("proportions", extra.getProportions());
					return customRepresentation;
				}
				throw new IllegalArgumentException(dataFetcherResult + " is not of type ExtraIngredients");
			}

			@Override
			public ExtraIngredients parseValue(Object input) throws CoercingParseValueException {
				// used for parsing
				return null;
			}

			@Override
			public ExtraIngredients parseLiteral(Object input) throws CoercingParseLiteralException {
				// used for parsing
				return null;
			}
		})
		.build();
}
