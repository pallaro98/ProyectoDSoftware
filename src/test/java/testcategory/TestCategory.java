package testcategory;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import category.Category;

public class TestCategory {
	Category cat;
	
	@Before
	public void setUp() {
	      cat = new Category();
	   }
	
	@Test
	public void testMult() {
		cat.setMult(1);
		assertEquals(1, cat.getMult());
	}
	
	@Test
	public void testMaxHR() {
		cat.setMaxHr(10.0);
		assertEquals(10.0, cat.getMaxHr(), .1);
	}
	
	

}
