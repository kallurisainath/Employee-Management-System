import java.util.List;
import java.util.Scanner;

import com.tap.*;
import com.tap.dao.EmployeeDAOImpl;
import com.tap.dto.*;
public class DriverClass {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = "YES";
		while(true) {
			System.out.println("Do you want to perform CRUD YES/NO");
			 str = s.next();
			 if(str.equals("NO")) {
				 break;
			 }
		System.out.println("Select the choice ");
		System.out.println("Enter 1 to get list of all the employees");
		System.out.println("Enter 2 to get the details of an employee");
		System.out.println("Enter 3 to update the salary of an employee");
		System.out.println("Enter 4 to delete the details of an employee");
		System.out.println("Enter 5 to insert the details of an employee");
		int i = s.nextInt();
		EmployeeDAOImpl obj = new EmployeeDAOImpl();
	
		
		if(i == 1) {
			System.out.println("Details of employees are as follows.....");
			List<Employee> lst = obj.getEmployees();
			for(Employee e : lst) {
				System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary() + " " + e.getDesignation());
			}
		} else if(i == 2) {
			System.out.println("Enter id to get details");
			int id = s.nextInt();
			Employee e = obj.getEmployee(id);
			System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary() + " " + e.getDesignation());
		} else if(i == 3) {
			System.out.println("Enter id and salary of the employee to update");
			int id = s.nextInt();
			int salary = s.nextInt();
			Employee e = obj.getEmployee(id);
			e.setSalary(salary);
			boolean bool = obj.updateEmployee(e);
		} else if(i == 4) {
			System.out.println("Enter id to delete the details of an employee");
			int id = s.nextInt();
			boolean bool = obj.deleteEmployee(id);
		} else if(i == 5) {
			System.out.println("Enter id to insert the details of an employee");
			int id = s.nextInt();
			String tmpp = s.nextLine();
			String name = s.next();
			String dd = s.nextLine();
			int salary = s.nextInt();
			String tmddpp = s.nextLine();
			String designation = s.nextLine();
			boolean bool = obj.insertEmployee(id, name, designation, salary);
		} else {
			System.out.println("Input is invalid.....");
		}
		}
	}
}
