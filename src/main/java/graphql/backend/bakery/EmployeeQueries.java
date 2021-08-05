package graphql.backend.bakery;

import graphql.backend.bakery.domain.Employee;
import graphql.backend.bakery.repository.EmployeeRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeQueries implements GraphQLQueryResolver {

	private final EmployeeRepository employeeRepository;


	public List<Employee> employees() {
		return employeeRepository.findAll();
	}

	public Employee employeesByName(String name) {
		return employeeRepository.findByName(name);
	}
}
