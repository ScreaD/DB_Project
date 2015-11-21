package ua.com.goit.gojava.kickstarter.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.Project;
import ua.com.goit.gojava.kickstarter.Projects;

public abstract class ProjectsTest {

	private Projects list;
	
	abstract Projects getProjects() throws Exception;

	@Before
	public void setup() throws Exception {
		list = getProjects();
	}
	
	@Test
	public void shouldEmptyProjects_whenNoProjects() {
		// when
		List<Project> found = list.getProjects(new Category(1, "name"));

		// then
		assertEquals(0, found.size());
	}
	
	@Test
	public void shouldEmptyProjects_whenNoProjectsWithSameCategory() {
		// given
		Category category = new Category(1, "category");

		Project project1 = new Project(1, "name", "description", 50, 100, 17, "history", "video");
		project1.setCategory(category);

		Project project2 = new Project(2, "name2", "description2", 100, 200, 34, "history2", "video2");
		project2.setCategory(category);

		list.add(project1);
		list.add(project2);

		// when
		List<Project> found = list.getProjects(new Category("name"));

		// then
		assertEquals(0, found.size());
	}
	
	@Test
	public void shouldFoundProjects_whenExistsProjectWithCategory() {
		// given
		Category category1 = new Category(1, "category1");
		Category category2 = new Category(2, "category2");

		Project project1 = new Project(1, "name", "description", 50, 100, 17, "history", "video");
		project1.setCategory(category1);

		Project project2 = new Project(2, "name2", "description2", 100, 200, 34, "history2", "video2");
		project2.setCategory(category2);

		Project project3 = new Project(3, "name3", "description3", 200, 400, 68, "history3", "video3");
		project3.setCategory(category2);

		list.add(project1);
		list.add(project2);
		list.add(project3);

		// when
		List<Project> found = list.getProjects(category2);

		// then
		assertEquals(2, found.size());

		assertEquals(project2, found.get(0));
		assertEquals(project3, found.get(1));
	}
	
//	@Test
//	public void shouldGetProject_whenExistsSomeProjects() {
//		Category category = new Category(1, "category1");
//
//		Project project1 = new Project(1, "name", "description", 50, 100, 17, "history", "video");
//		project1.setCategory(category);
//
//		Project project2 = new Project(2, "name2", "description2", 100, 200, 34, "history2", "video2");
//		project2.setCategory(category);
//
//		list.add(project1);
//		list.add(project2);
//
//		// when then
//		assertEquals(project1, list.get(100500));
//		assertEquals(project2, list.get(1005001));
//	} // TODO implement correctly project's add new project
	
//	@Test
//	// напишем юнит тест на эту функциональность
//	public void shouldAddQuestion_whenAskIt() {
//		// given
//		Project project = new Project(1, "name", 100, 10, "video", "description");
//		assertEquals(null, project.getQuestionAnswers());
//
//		// when
//		project.addQuestionAnswer("question");
//
//		// then
//		assertEquals("question", project.getQuestionAnswers());
//
//	}
//
//	@Test
//	// напишем юнит тест на эту функциональность
//	public void shouldAddSecondQuestion_whenAskIt() {
//		// given
//		Project project = new Project(1, "name", "description", 50, 100, 17, "history", "video");
//		project.addQuestionAnswer("question");
//
//		// when
//		project.addQuestionAnswer("answer answer"); // проблема не тут
//
//		// then
//		assertEquals("question\nanswer answer", project.getQuestionAnswers());
//
//	}
	
}
