package ua.com.goit.gojava.kickstarter.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.kickstarter.Categories;
import ua.com.goit.gojava.kickstarter.Category;

public abstract class CategoriesTest {

	private Categories list;

	@Before
	public void setup() throws Exception {
		list = getCategories();		
	}

	abstract Categories getCategories() throws Exception;
	
	@Test 
	public void shouldMultithreadTest() {
		// given
		list.add(new Category(1, "name1"));
		list.add(new Category(2, "name2"));
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10000; i++) {
					list.getCategories();				
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10000; i++) {
					list.getCategories();				
				}
			}
		}).start();
		
		for (int i = 0; i <= 1000; i++) {
			list.getCategories();				
		}
	}
	
	@Test 
	public void shouldCalegoriesList_whenAddCategories() {
		// given
		list.add(new Category(1, "name1"));
		list.add(new Category(2, "name2"));
		
		// when 
		List<Category> categories = list.getCategories();
		
		// then
		assertEquals("[1 - name1, 2 - name2]", 
				categories.toString());
	}
	
	@Test 
	public void shouldCalegoriesList_whenNoCategories() {
		// when 
		List<Category> categories = list.getCategories();
		
		// then
		assertEquals("[]", 
				categories.toString());
	}
	
	@Test 
	public void shouldGetCategoryByIndex() {
		Category category1 = new Category(1, "name1");
		list.add(category1);
		
		Category category2 = new Category(2, "name2");
		list.add(category2);
		
		// when then
		assertEquals(category1, list.get(1));
		assertEquals(category2, list.get(2));
	}
	
	@Test 
	public void shouldGetCalegoriesListSize_whenNoCategories() {
		// given
		assertEquals(0, list.size());
	}
	
	@Test 
	public void shouldGetCalegoriesListSize_whenAddCategories() {
		// when 
		list.add(new Category(1, "name1"));
		list.add(new Category(2, "name2"));
		
		// then
		assertEquals(2, list.size());
	}
}
