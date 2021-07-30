package graphql.backend;

import graphql.backend.bakery.CustomScalars;
import graphql.backend.bakery.domain.Bakery;
import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.domain.ExtraIngredients;
import graphql.backend.bakery.repository.BakeryRepository;
import graphql.backend.bakery.repository.BreadRepository;
import graphql.schema.GraphQLScalarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static graphql.backend.bakery.domain.FlourType.*;
import static graphql.com.google.common.primitives.Ints.asList;

@SpringBootApplication
@ComponentScan(basePackages = "graphql.backend")
public class BakeryApplication {

	@Autowired
	private BreadRepository breadRepository;

	@Autowired
	private BakeryRepository bakeryRepository;

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class);
	}

	@PostConstruct
	public void initializeBreads() {
		initRepository();
	}

	@Bean
	public GraphQLScalarType getExtraIngredients() {
		return CustomScalars.EXTRA_INGREDIENTS;
	}

	private void initRepository() {
		breadRepository.addBread(new Bread(1, "Baguette", 40, Arrays.asList(ALL_PURPOSE, BUCKWHEAT), new ExtraIngredients(Arrays.asList("water", "milk"), "1 - 1.5")));
		breadRepository.addBread(new Bread(2, "Ciabatta", 50, Arrays.asList(ALL_PURPOSE, AMARANTH), new ExtraIngredients(Arrays.asList("olives", "white cheese"), "by taste")));

		bakeryRepository.addBakery(new Bakery(1, "MA BAKERY", asList(1, 2)));
	}
}
