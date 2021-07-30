package graphql.backend.bakery.repository;

import graphql.backend.bakery.domain.Bakery;
import graphql.backend.bakery.domain.Bread;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BakeryRepository {

	private final Map<Integer, Bakery> bakeries = new HashMap<>();

	public List<Bakery> findAll() {
		return new ArrayList<>(bakeries.values());
	}

	public void addBakery(Bakery bread) {
		bakeries.put(bread.getId(), bread);
	}
}
