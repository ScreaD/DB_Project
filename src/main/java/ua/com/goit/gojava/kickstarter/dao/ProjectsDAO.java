package ua.com.goit.gojava.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.Projects;

@Component
public class ProjectsDAO extends AbstractDAO implements Projects {
	
	@Override
	public void add(Project project) { // TODO implement correctly project's add new project
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"insert into projects (name, description, category_id) values (?, ?, ?)"); //TODO add all rows
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setInt(3, project.getCategory().getId());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with adding new project", e);
		}
	}

	@Override
	public List<Project> getProjects(Category category) {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement(); 
			List<Project> result = new LinkedList<Project>();

			ResultSet rs = statement.executeQuery(
					"select * from projects where category_id = " + category.getId());
			while (rs.next()) {
				Project project = new Project(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("description"));
				project.setCategory(category);
				result.add(project);
			}	
			
			return result;
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with getting all projects", e);
		}
	}
	
	@Override
	public Project get(int index) {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement(); 

			ResultSet rs = statement.executeQuery("select * from projects WHERE id = " + index);
			
			if (rs.next()) {
				Project project = new Project(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getInt("collected"),
						rs.getInt("amount"),
						rs.getInt("days"),
						rs.getString("history"),
						rs.getString("video"));
				return project;
			}
			throw new RuntimeException("There is no category with id = " + index);
			
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong while getting project by id", e);
		}
	}

	@Override
	public void donate(int id, int amount) {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select amount from projects WHERE id = " + id);
			int currentAmount;
			if (rs.next()) {
				currentAmount = rs.getInt("amount");
				statement.executeQuery("update projects SET amount = " + (currentAmount + amount)
											+ "WHERE id = " + id);
			}
			throw new RuntimeException("There is no category with id = " + id);
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong while getting project by id", e);
		}
	}

}
