package ua.com.goit.gojava.kickstarter.serivce;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.fest.reflect.core.Reflection;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;
import ua.com.goit.gojava.kickstarter.service.CategoriesProjectsService;

public class CopyOfCategoriesProjectsServiceTest_WithoutSpring {

	@Test
	public void test() {
		CategoriesDAO categoriesDao = mock(CategoriesDAO.class);
		ProjectsDAO projectsDao = mock(ProjectsDAO.class);
		CategoriesProjectsService service = new CategoriesProjectsService();
		inject(service, categoriesDao, projectsDao);
		
		// given 
		Category category = new Category(1, "cat1");
		when(categoriesDao.get(1)).thenReturn(category);
		when(projectsDao.getProjects(category)).thenReturn(Arrays.asList(new Project(1, "proj1", "descr1")));
		
		// when 
		List<Project> result = service.getCategoryProjects(1);
		
		// then
		assertEquals("[Project [id=1, name=proj1]]", result.toString());
	}

	private void inject(CategoriesProjectsService service,
			CategoriesDAO categoriesDao, ProjectsDAO projectsDao) {
		Reflection.field("categoriesDao").ofType(CategoriesDAO.class).in(service).set(categoriesDao);
		Reflection.field("projectsDao").ofType(ProjectsDAO.class).in(service).set(projectsDao);
	}
}
