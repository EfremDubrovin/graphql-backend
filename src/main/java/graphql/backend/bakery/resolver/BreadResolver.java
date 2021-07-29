package graphql.backend.bakery.resolver;

import graphql.backend.bakery.domain.Bread;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BreadResolver implements GraphQLResolver<Bread> {
}
