package graphql.backend.bakery;

import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.repository.BreadRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BakeryMutations implements GraphQLMutationResolver {

	private final BreadRepository breadRepository;

	public Bread createBread(String name) {
		Bread bread = new Bread(name);
		breadRepository.addBread(bread);
		return bread;
	}
}
