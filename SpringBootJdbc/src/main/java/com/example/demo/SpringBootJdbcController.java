package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootJdbcController {

	@Autowired
	JdbcTemplate jdbc;
	
	@RequestMapping("/insert")
	public String insert() {
		
		jdbc.execute("insert into employee(name, salary) values('shahin', 50000)");
		return "data inserted successfully";
	}
	
	@RequestMapping("/update")
	public String update() {
		
		jdbc.execute("update employee set name = 'urmi' where id = 5");
		return "data updated successfully";
	}
}
