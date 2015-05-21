package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Categories;
import ua.com.goit.gojava.kickstarter.Category;

@Component
public class CategoriesDAO extends AbstractDAO implements Categories {
	
	@Override
	public void add(final Category category) { // TODO implement correctly category's add new project
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement("insert into categories (name) values (?)");
			statement.setString(1, category.getName());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with adding new category", e);
		} 
	}

	@Override
	public List<Category> getCategories() {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement(); 
			List<Category> result = new LinkedList<Category>();

			ResultSet rs = statement.executeQuery("select * from categories");
			while (rs.next()) {
				result.add(new Category(rs.getInt("id"), rs.getString("name")));
			}	
			
			return result;
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with getting all categories", e);
		}
	}
	
	@Override
	public Category get(final int id) {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement(); 

			ResultSet rs = statement.executeQuery("select * from categories where id = " + id);
			while (rs.next()) {
				return new Category(rs.getInt("id"), rs.getString("name"));
			}	
			
			throw new RuntimeException("There is no category with id = " + id);
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with getting category by id", e);
		}
	}

	@Override
	public int size() {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement(); 

			ResultSet rs = statement.executeQuery("select count(*) from categories");
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong while calculation categories size", e);
		}
	}
}
