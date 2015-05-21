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

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava.kickstarter.Categories;
import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.Projects;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.mock.CategoriesDAOMock;
import ua.com.goit.gojava.kickstarter.dao.mock.DataSourceMock;
import ua.com.goit.gojava.kickstarter.dao.mock.ProjectsDAOMock;
import ua.com.goit.gojava.kickstarter.service.CategoriesProjectsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		CategoriesProjectsService.class, 
		ProjectsDAOMock.class,
		CategoriesDAOMock.class,
		DataSourceMock.class
})
public class CategoriesProjectsServiceTest_WithSpring {

//	@Autowired  // TODO correct test!!
//	private Categories categoriesDao;
//
//	@Autowired
//	private Projects projectsDao;
//
//	@Autowired
//	private CategoriesProjectsService service;
//
//	@Test
//	public void test() {
//		// given
//		Category category = new Category(1, "cat1");
//		when(categoriesDao.get(1)).thenReturn(category);
//		when(projectsDao.getProjects(category)).thenReturn(Arrays.asList(new Project(1, "proj1", "descr1")));
//
//		// when
//		List<Project> result = service.getCategoryProjects(1);
//
//		// then
//		assertEquals("[Project [id=1, name=proj1]]", result.toString());
//	}


}
