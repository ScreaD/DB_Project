package ua.com.goit.gojava.kickstarter.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Categories;
import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.Projects;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;

@Component
public class CategoriesProjectsService {
	
	@Autowired
	private CategoriesDAO categoriesDao;
	
	@Autowired
	private ProjectsDAO projectsDao;

	public List<Project> getCategoryProjects(int categoryId) {
		Category category = categoriesDao.get(categoryId);
		List<Project> projects = projectsDao.getProjects(category);
		return projects;
	}
}
