package ua.com.goit.gojava.kickstarter.dao.mock;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDAO;

public class ProjectsDAOMock {
	@Bean(name = "projectsDao")
    public ProjectsDAO bean() throws Exception {
        return Mockito.mock(ProjectsDAO.class);
    }
}
