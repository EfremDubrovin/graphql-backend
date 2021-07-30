package graphql.backend.bakery.resolver;

import graphql.backend.bakery.domain.Bakery;
import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.repository.BakeryRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BreadResolver implements GraphQLResolver<Bread> {

	private final BakeryRepository bakeryRepository;

	public Bakery bakery(Bread bread) {
		return bakeryRepository.findAll().stream()
			.filter(bakery -> bakery.getBreadIds().contains(bread.getId()))
			.findFirst()
			.orElse(null);
	}
}
