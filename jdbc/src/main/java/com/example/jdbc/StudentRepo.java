package com.example.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
	
	// jdbc obj
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Student s1) {
		// student table
		String sql = "insert into student (rno, name, batch) values (?,?,?)";
		int status = template.update(sql, s1.getRno(), s1.getName(), s1.getBatch());
		System.out.println(status);
		System.out.println("Record saved");
	}
	
	public List<Student> display() {
		// rowmapper
		return template.query("SELECT * FROM student", new RowMapper<Student>() {
			 
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setRno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setBatch(rs.getString(3));
                return student;
            }
        });
	}
}
