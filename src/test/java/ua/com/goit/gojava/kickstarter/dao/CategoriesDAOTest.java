package ua.com.goit.gojava.kickstarter.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava.kickstarter.Categories;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
public class CategoriesDAOTest extends CategoriesTest {

	@Autowired
	private CategoriesDAO categoriesDao;
	
	@Autowired
	private DataSource dataSource;

	@BeforeClass
	public static void cleanDB() {
		new File(ProjectsDAOTest.DATABASE_PATH).delete();
	}
	
	@After
	public void clenup() throws Exception {
		Connection connection = dataSource.getConnection();
		
		try {		
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS Categories (" +
								  "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
								  "name TEXT NOT NULL UNIQUE" +
								");");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Categories;");
			
			statement = connection.createStatement();
			statement.execute("delete from sqlite_sequence where name='Categories';");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		connection.close();
	}
	
	@Override
	Categories getCategories() throws Exception {
		clenup();
		
		return categoriesDao;
	}


}
