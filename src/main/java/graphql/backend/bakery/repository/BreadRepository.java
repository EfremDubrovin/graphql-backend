package graphql.backend.bakery.repository;

import graphql.backend.bakery.domain.Bread;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class BreadRepository {

	private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(100);

	private final Map<Integer, Bread> breads = new HashMap<>();

	public List<Bread> findAll() {
		return new ArrayList<>(breads.values());
	}

	public void addBread(Bread bread) {
		if (bread.getId() == null) {
			int newId = ID_SEQUENCE.incrementAndGet();
			bread.setId(newId);
		}
		breads.put(bread.getId(), bread);
	}
}
