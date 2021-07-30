package graphql.backend;

import graphql.backend.bakery.CustomScalars;
import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.domain.ExtraIngredients;
import graphql.backend.bakery.repository.BreadRepository;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static graphql.backend.bakery.domain.FlourType.*;

@SpringBootApplication
@ComponentScan(basePackages = "graphql.backend")
public class BakeryApplication {

	@Autowired
	private BreadRepository breadRepository;

	@Autowired
	private CustomScalars customScalars;

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class);
	}

	@PostConstruct
	public void initializeBreads() {
		initRepository();
	}

	@Bean
	public GraphQLScalarType getExtraIngredients() {
		return customScalars.getExtraIngredients();
	}

	private void initRepository() {
		breadRepository.addBread(new Bread(2, "Baguette", 40, Arrays.asList(ALL_PURPOSE, BUCKWHEAT), new ExtraIngredients(Arrays.asList("water", "milk"), "1 - 1.5")));
		breadRepository.addBread(new Bread(4, "Ciabatta", 50, Arrays.asList(ALL_PURPOSE, AMARANTH), new ExtraIngredients(Arrays.asList("olives", "white cheese"), "by taste")));
	}
}
