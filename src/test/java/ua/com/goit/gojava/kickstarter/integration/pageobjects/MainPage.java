package ua.com.goit.gojava.kickstarter.integration.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ua.com.goit.gojava.kickstarter.Project;

public class MainPage {

	private WebDriver driver;
	
	public MainPage(WebDriver driver, String url) {
		this.driver = driver;
		
		driver.get(url);
		
		wait(driver, "#categories div");
	}

	public static void wait(WebDriver driver, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
	}

	public CategoriesList getCategories() {
		CategoriesList result = new CategoriesList(driver);
		PageFactory.initElements(driver, result);
		return result;
	}

	public void exit() {
		driver.close();
	}

	public ProjectsList getProjects() {
		ProjectsList result = new ProjectsList(driver);
		PageFactory.initElements(driver, result);
		return result;
	}

	public ProjectInfo getProject() {
		ProjectInfo result = new ProjectInfo(driver);
		PageFactory.initElements(driver, result);
		return result;
	}

}
