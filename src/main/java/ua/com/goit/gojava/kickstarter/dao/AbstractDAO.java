package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AbstractDAO {
	
	@Autowired
	private DataSource dataSource;

	Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
