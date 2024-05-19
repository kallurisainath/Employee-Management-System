package com.tap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.connector.ConnectorFactory;
import com.tap.dto.Employee;

public class EmployeeDAOImpl implements employeeDAO{

	@Override
	public List getEmployees() {
		ArrayList<Employee> emplist = null;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			emplist = new ArrayList<Employee>();
			while(res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				int salary = res.getInt(3);
				String designation = res.getString(4);
				Employee emp = new Employee(id, name, salary, designation);
				emplist.add(emp);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emplist;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp = null;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "select * from employee where id = " + id;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			res.next();
			emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public boolean insertEmployee(int id, String name, String designation, int salary) {
		int i = 0;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "INSERT INTO employee (id, name, salary, designation) VALUES (?, ?, ?, ?)";			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, salary);
			stmt.setString(4, designation);
			i = stmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		int i = 0;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "update employee set salary=? where id = ?;";			
			PreparedStatement stmt = con.prepareStatement(query);
			int newSalary = e.getSalary();
			int id = e.getId();
			stmt.setInt(1, newSalary);
			stmt.setInt(2,  id);
			i = stmt.executeUpdate();
			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		if(i == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		int i = 0;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "delete from employee where id = ?;";			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,  id);
			i = stmt.executeUpdate();
			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		if(i == 1) {
			return true;
		}
		return false;
	}

	
	
}
