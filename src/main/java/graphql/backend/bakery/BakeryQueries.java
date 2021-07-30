package graphql.backend.bakery;

import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.repository.BreadRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BakeryQueries implements GraphQLQueryResolver {

	private final BreadRepository breadRepository;

	public List<Bread> breads() {
		return breadRepository.findAll();
	}
}
