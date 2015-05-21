package ua.com.goit.gojava.kickstarter.integration.pageobjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoriesList {

	@FindBy(how = How.ID, using = "categories")
	private WebElement container;
	
	private WebDriver driver;

	public CategoriesList(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getAll() {
		List<WebElement> childNodes = container.findElements(By.tagName("div"));
		
		List<String> names = new LinkedList<String>();
		for (WebElement category : childNodes) {
			names.add(category.getText());
		}
		
		return names;
	}

	public void click(int id) {
		WebElement category = container.findElement(By.id("category_" + id));
		category.click();
		
		MainPage.wait(driver, "#projects div");
	}

}
