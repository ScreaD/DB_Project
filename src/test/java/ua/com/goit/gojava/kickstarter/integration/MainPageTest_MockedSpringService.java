package ua.com.goit.gojava.kickstarter.integration;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;
import ua.com.goit.gojava.kickstarter.integration.mocker.SpringMockerJettyRunner;
import ua.com.goit.gojava.kickstarter.integration.pageobjects.CategoriesList;
import ua.com.goit.gojava.kickstarter.integration.pageobjects.MainPage;
import ua.com.goit.gojava.kickstarter.integration.pageobjects.ProjectInfo;
import ua.com.goit.gojava.kickstarter.integration.pageobjects.ProjectsList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainPageTest_MockedSpringService {
    private WebDriver driver;
    private SpringMockerJettyRunner runner;
    private CategoriesDAO categoriesDAO;
    private ProjectsDAO projectsDAO;

    @Before
    public void startServer() throws Exception {
        runner = new SpringMockerJettyRunner("src/main/webapp", "/kickstarter");
    }

    @After
    public void stop() throws Exception {
        runner.stop();
    }

    @Test
    public void test() throws Exception {
        // given
        runner.mockBean("categoriesDao");
        runner.mockBean("projectsDao");
        runner.start();
        categoriesDAO = runner.getBean("categoriesDao");
        projectsDAO = runner.getBean("projectsDao");
    
        Category category1 = new Category(1, "cat1");
		when(categoriesDAO.getCategories())
    			.thenReturn(Arrays.asList(category1, new Category(2, "cat2")));

        // when
        MainPage page = new MainPage(new ChromeDriver(), runner.getUrl());
		
		CategoriesList categories = page.getCategories();
		
		// then
		assertEquals("[cat1, cat2]", categories.getAll().toString());
		
		verify(categoriesDAO).getCategories();
		
		// --------------------------
		// given
		when(categoriesDAO.get(1)).thenReturn(category1);
		when(projectsDAO.getProjects(category1))
				.thenReturn(Arrays.asList(new Project(1, "proj1", "descr1"), new Project(2, "proj2", "descr1")));
		
		// when
		categories.click(1);
		
		// then 
		verify(projectsDAO).getProjects(category1);
		verify(categoriesDAO).get(1);
		
		ProjectsList projects = page.getProjects();
		assertEquals("[proj1, proj2]", projects.getAll().toString());
		
		// --------------------------
		// given
		when(projectsDAO.get(anyInt()))
			.thenReturn(new Project(3, "proj3", "descr3"));
		
		// when
		projects.click(2);
		
		// then 
		verify(projectsDAO).get(2);
		ProjectInfo project = page.getProject();
		
		assertEquals("[name: proj3, description: descr3]", project.toString());
		
		// exit
		page.exit();
    }



}