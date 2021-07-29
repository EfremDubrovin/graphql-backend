package graphql.backend;

import graphql.GraphQL;
import graphql.backend.bakery.BakeryQueries;
import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.repository.BreadRepository;
import graphql.backend.bakery.resolver.BreadResolver;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@SpringBootApplication
@ComponentScan(basePackages = "graphql.backend")
public class BakeryApplication {

	@Autowired
	private BreadRepository breadRepository;

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class);
	}

	@PostConstruct
	public void initializeBreads() {
		breadRepository.addBread(new Bread(1, "Banana Bread"));
		breadRepository.addBread(new Bread(2, "Baguette"));
		breadRepository.addBread(new Bread(3, "Brioche"));
		breadRepository.addBread(new Bread(4, "Ciabatta"));
		breadRepository.addBread(new Bread(5, "Multigrain Bread"));
	}

//	@Bean
//	public GraphQL graphQL(GraphQLSchema graphQLSchema) {
//		return GraphQL.newGraphQL(graphQLSchema).build();
//	}
//
//	@Bean
//	public GraphQLSchema graphQLSchema(BakeryQueries bakeryQueries, BreadResolver breadResolver) {
//		return SchemaParser.newParser()
//			.files("graphql/Bread.graphqls", "graphql/schema.graphqls")
//			.resolvers(bakeryQueries, breadResolver)
//			.build()
//			.makeExecutableSchema();
//	}
}
