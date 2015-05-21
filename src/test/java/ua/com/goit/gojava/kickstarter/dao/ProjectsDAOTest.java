package ua.com.goit.gojava.kickstarter.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava.kickstarter.Projects;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-application-context.xml" })
public class ProjectsDAOTest extends ProjectsTest {

	public static final String DATABASE_PATH = "./target/test-classes/test-database.db";
	
	@Autowired
	private ProjectsDAO projectsDao;
	
	@Autowired
	private DataSource dataSource;
	
	@BeforeClass
	public static void cleanDB() {
		new File(DATABASE_PATH).delete();
	}
	
	@Override
	Projects getProjects() throws Exception {	
		Connection connection = dataSource.getConnection();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS Projects (" +
								"id	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
								"category_id	INTEGER NOT NULL," +
								"name	TEXT NOT NULL UNIQUE," +
								"description	TEXT" +
							")");
			
			statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS Categories (" +
								  "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
								  "name TEXT NOT NULL UNIQUE" +
								");");
		} catch (SQLException e) {
			// do nothing
		}
		
		try {
			Statement statement = connection.createStatement();
			statement.execute("DELETE FROM Categories;");
			
			statement = connection.createStatement();
			statement.execute("delete from sqlite_sequence where name='Categories';");
			
			statement = connection.createStatement();
			statement.execute("DELETE FROM Projects;");
			
			statement = connection.createStatement();
			statement.execute("delete from sqlite_sequence where name='Projects';");
		} catch (SQLException e) {
			// do nothing
		}
		
		PreparedStatement statement2 = connection.prepareStatement("insert into categories (name) values (?)");
		statement2.setString(1, "category1");
		statement2.execute();
		
		connection.close();
		
		return projectsDao;
	}

}
