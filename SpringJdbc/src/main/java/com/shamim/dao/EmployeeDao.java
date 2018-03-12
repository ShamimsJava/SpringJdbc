package com.shamim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.shamim.pojo.Employee;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Employee e) {

		String sql = "insert into employee values('" + e.getId() + "', '" + e.getName() + "', '" + e.getSalary() + "')";

		jdbcTemplate.update(sql);
	}

	public void update(Employee e) {

		String sql = "update employee set name = '" + e.getName() + "', salary = '" + e.getSalary() + "' where id = '"
				+ e.getId() + "'";

		jdbcTemplate.update(sql);
	}

	public void delete(Employee e) {

		String sql = "delete from employee where id = '" + e.getId() + "'";

		jdbcTemplate.update(sql);
	}
	
	public List<Employee> getAll(){
		
		String sql = "select * from employee";
		
		RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
			
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Employee emp = new Employee();
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				
				return emp;
			}
		};
		
		List<Employee> list = jdbcTemplate.query(sql, rowMapper);
		
		return list;
		
	}
}
