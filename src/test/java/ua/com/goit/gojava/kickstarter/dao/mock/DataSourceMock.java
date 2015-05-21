package ua.com.goit.gojava.kickstarter.dao.mock;

import javax.sql.DataSource;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

public class DataSourceMock {
	@Bean(name = "dataSource")
    public DataSource bean() throws Exception {
        return Mockito.mock(DataSource.class);
    }
}
