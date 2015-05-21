package ua.com.goit.gojava.kickstarter;

import java.util.List;

public interface Categories {

	void add(Category category);
	
	List<Category> getCategories();
	
	Category get(int id);
	
	int size();

	boolean exists(int id);
}
