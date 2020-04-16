package testlevel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import level.BasicLevel;

public class TestBasicLevel {
	BasicLevel bl;

	
	@Before
	public void setUp() {
	      bl = new BasicLevel();
	   }
	
	@Test
	public void testLevel() {
		bl.getLevel();
		assertEquals("Basic", bl.getLevel());
	}
	
	
}
