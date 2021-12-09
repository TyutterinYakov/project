package dao;

import java.util.List;


import entitiy.Employee;

public interface EmployeeDao {
	void addEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployee(Long emId);
	void updateEmployee(Long emIdForUpdate, Employee emp);
	void removeEmployee(Employee emp);
}
