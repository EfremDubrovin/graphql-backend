# graphql-backend
the task:
1. create an Employee graphqls type with fields https://spec.graphql.org/June2018/#sec-Int
 - name - String
 - age - Int
 - personalInfo - free text (String)
2. create a query definition to fetch all employees or by name
3. create a mutation definition to add an employee, which returns the added Employee. For input create a EmployeeInput type
4. create a Employee domain class with needed properties
5. create a EmployeeRepository to save the Employee - get insipired from BreadRepository on id generation
6. create a EmployeeQueries and EmployeeMutations to resolve the graphql query and mutation
7. do a manual test to add two employees with the mutation and fetch them with the query
