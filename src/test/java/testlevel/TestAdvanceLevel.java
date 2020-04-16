package testlevel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import level.AdvanceLevel;


public class TestAdvanceLevel {
	AdvanceLevel al;

	
	@Before
	public void setUp() {
	      al = new AdvanceLevel();
	   }
	
	@Test
	public void testLevel() {
		al.getLevel();
		assertEquals("Advanced", al.getLevel());
	}
}
