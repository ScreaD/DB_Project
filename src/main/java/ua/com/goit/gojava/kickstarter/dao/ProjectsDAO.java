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
	public void add(Project project) {
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(
					"insert into projects (name, description, category_id) values (?, ?, ?)"); //TODO add all rows
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setInt(3, project.getCategory().getId());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Что-то не так с запросом", e);
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
			throw new RuntimeException("Что-то не так с запросом", e);
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
				
//				Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
				
//				project.setCategory(category);
					
				return project;
			}
			throw new RuntimeException("Не нашли проект с id = " + index);
			
		} catch (SQLException e) {
			throw new RuntimeException("Что-то не так с запросом", e);
		}
	}

}
