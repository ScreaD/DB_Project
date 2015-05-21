package ua.com.goit.gojava.kickstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Faq;
import ua.com.goit.gojava.kickstarter.Faqs;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.FaqsDAO;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;

@Controller
public class RestController {

	@Autowired
	private CategoriesDAO categoriesDao;
	
	@Autowired
	private ProjectsDAO projectsDao;

	@Autowired
	private FaqsDAO faqsDao;
	
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
	
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String getProject(@PathVariable int id, Model model) {
		Project project = projectsDao.get(id);
		model.addAttribute("project", project);
		return "project";
	}

	@RequestMapping(value = "projects/{id}/payment", method = RequestMethod.GET)
	public String paymentPage(@PathVariable int id, Model model) {
		Project project = projectsDao.get(id);
		model.addAttribute("project", project);
		return "payment";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String addMoney(@PathVariable int id, Model model, @RequestParam("amount") int amount) {
		projectsDao.donate(id, amount);
		Project project = projectsDao.get(id);
		model.addAttribute("project", project);
		return "project";
	}

	@RequestMapping(value = "projects/{id}/faqs")
	public String getFaq(@PathVariable int id, Model model) {
		List<Faq> faqs = faqsDao.get(id);
		model.addAttribute("faqs", faqs);
		return "faqs";
	}
}
