package ua.com.goit.gojava.kickstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;

@Controller
public class RestController {

	@Autowired
	private CategoriesDAO categoriesDao;
	
	@Autowired
	private ProjectsDAO projectsDao;
	
	@RequestMapping(value = "/")
	public String getMainPage(Model model) {
		List<Category> categories = categoriesDao.getCategories();
		model.addAttribute("categories", categories);
		return "categories";
	}
	
	@RequestMapping(value = "/categories")
	public String getCategories(Model model) {
		List<Category> categories = categoriesDao.getCategories();
		model.addAttribute("categories", categories);
		return "categories";
	} 
	
	@RequestMapping(value = "/categories/{id}")
	public String getProjectsByCategory(@PathVariable int id, Model model) {
		Category category = categoriesDao.get(id);
		List<Project> projects = projectsDao.getProjects(category);
		model.addAttribute("projects", projects);
		return "projects";
	}
	
	@RequestMapping(value = "/projects/{id}")
	public String getProject(@PathVariable int id, Model model) {
		Project project = projectsDao.get(id);
		model.addAttribute("project", project);
		return "project";
	} 
}
