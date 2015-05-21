package ua.com.goit.gojava.kickstarter.integration;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ua.com.goit.gojava.kickstarter.integration.mocker.JettyRunner;
import ua.com.goit.gojava.kickstarter.integration.pageobjects.CategoriesList;
import ua.com.goit.gojava.kickstarter.integration.pageobjects.MainPage;

public class MainPageTest_WithPageObject {

	private JettyRunner runner;
	private ChromeDriver driver;

	@Before
	public void setup() throws Exception {
		runner = new JettyRunner("src/main/webapp", "/kickstarter");
		runner.start();
		driver = new ChromeDriver();
	}
	
	@After
	public void after() throws Exception {
		driver.close();
		runner.stop();
	}
	
	@Test
	public void test() throws InterruptedException {
		MainPage page = new MainPage(new ChromeDriver(), runner.getUrl());
		
		CategoriesList categories = page.getCategories();
		
		assertEquals("[Cat 1, Cdt 2, Cat 3]", categories.getAll().toString());
		
		page.exit();
	}	
	
}
