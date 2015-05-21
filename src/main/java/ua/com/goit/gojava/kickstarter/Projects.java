
package ua.com.goit.gojava.kickstarter;

import java.util.List;

public interface Projects {

	void add(Project project);

	List<Project> getProjects(Category category);

	Project get(int index);

	void donate(int id, int amount);

}
