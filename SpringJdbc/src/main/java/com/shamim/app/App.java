package com.shamim.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shamim.dao.EmployeeDao;
import com.shamim.pojo.Employee;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/shamim/beans/beans.xml");
		
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("employeedao");
		
		Employee e = new Employee(2, "urmi", 40000);
		
		employeeDao.save(e);
		//employeeDao.update(e);
		//employeeDao.delete(e);
		
		List<Employee> list = employeeDao.getAll();
		
		for(Employee allEmp : list) {
			
			System.out.println(allEmp);
		}
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
