package ua.com.goit.gojava.kickstarter.integration.pageobjects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProjectInfo {

	@FindBy(how = How.ID, using = "project")
	private WebElement container;
	private WebDriver driver;
	
	public ProjectInfo(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		List<WebElement> elements = container.findElements(By.tagName("div"));
		List<String> result = new LinkedList<String>();
		for (WebElement element : elements) {
			result.add(element.getText());
		}
		return result.toString();
	}
	
}
