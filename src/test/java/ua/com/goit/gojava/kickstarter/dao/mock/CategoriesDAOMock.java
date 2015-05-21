package ua.com.goit.gojava.kickstarter.dao.mock;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

import ua.com.goit.gojava.kickstarter.dao.CategoriesDAO;

public class CategoriesDAOMock {
	@Bean(name = "categoriesDao")
    public CategoriesDAO bean() throws Exception {
        return Mockito.mock(CategoriesDAO.class);
    }
}
