package graphql.backend;

import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.repository.BreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static graphql.backend.bakery.domain.FlourType.*;
import static java.util.Collections.singletonList;

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
		breadRepository.addBread(new Bread(1, "Banana Bread", null, singletonList(ALMOND)));
		breadRepository.addBread(new Bread(2, "Baguette", 40, Arrays.asList(ALL_PURPOSE, BUCKWHEAT)));
		breadRepository.addBread(new Bread(3, "Brioche", 40, Arrays.asList(ALL_PURPOSE, BARLEY)));
		breadRepository.addBread(new Bread(4, "Ciabatta", 50, Arrays.asList(ALL_PURPOSE, AMARANTH)));
		breadRepository.addBread(new Bread(5, "Multigrain Bread", 55, singletonList(ALL_PURPOSE)));
	}
}
