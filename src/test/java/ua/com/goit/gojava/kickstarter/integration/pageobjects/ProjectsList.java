package ua.com.goit.gojava.kickstarter.integration.pageobjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProjectsList {
	
	@FindBy(how = How.ID, using = "projects")
	private WebElement container;
	private WebDriver driver;

	public ProjectsList(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getAll() {
		List<WebElement> childNodes = container.findElements(By.tagName("div"));
		
		List<String> names = new LinkedList<String>();
		for (WebElement projects : childNodes) {
			names.add(projects.getText());
		}
		
		return names;
	}

	public void click(int id) {
		WebElement project = container.findElement(By.id("project_" + id));
		project.click();
		
		MainPage.wait(driver, "#project div");
	}
}
