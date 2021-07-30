package graphql.backend.bakery.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Bakery {
	private final int id;
	private final String name;
	private final List<Integer> breadIds;
}
