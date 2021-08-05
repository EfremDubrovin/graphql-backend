package graphql.backend.bakery.repository;

import graphql.backend.bakery.domain.Bread;
import graphql.backend.bakery.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EmployeeRepository {
	private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(100);
	private final Map<Integer, Employee> employees = new HashMap<>();

	public List<Employee> findAll() {
		return new ArrayList<>(employees.values());
	}

	public Employee findByName(String name) {
		return employees.values().stream()
			.filter(employee -> employee.getName().equals(name))
			.findFirst().orElse(null);
	}

	public void addEmployee(Employee employee) {
		if (employee.getId() == null) {
			int newId = ID_SEQUENCE.incrementAndGet();
			employee.setId(newId);
		}
		employees.put(employee.getId(), employee);
	}
}
