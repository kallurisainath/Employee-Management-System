package com.tap.dao;

import java.util.List;

import com.tap.dto.Employee;

public interface employeeDAO {

	List getEmployees();
	Employee getEmployee(int id);
	boolean insertEmployee(int id, String name, String designation, int salary);
	boolean updateEmployee(Employee e);
	boolean deleteEmployee(int id);
	
}
