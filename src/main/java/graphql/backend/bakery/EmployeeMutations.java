package graphql.backend.bakery;

import graphql.backend.bakery.domain.Employee;
import graphql.backend.bakery.repository.EmployeeRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMutations implements GraphQLMutationResolver {
	private final EmployeeRepository employeeRepository;

	public Employee createEmployee(EmployeeInput employee) {
		Employee newEmployee = new Employee(employee.getName(), employee.getAge(), employee.getPersonalInfo());
		employeeRepository.addEmployee(newEmployee);
		return newEmployee;
	}
}
