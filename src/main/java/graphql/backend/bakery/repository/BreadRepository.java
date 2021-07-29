package graphql.backend.bakery.repository;

import graphql.backend.bakery.domain.Bread;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BreadRepository {

	private final Map<Integer, Bread> breads = new HashMap<>();

	public List<Bread> findAll() {
		return new ArrayList<>(breads.values());
	}

	public void addBread(Bread bread) {
		breads.put(bread.getId(), bread);
	}
}
