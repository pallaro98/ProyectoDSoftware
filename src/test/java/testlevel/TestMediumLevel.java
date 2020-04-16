package testlevel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import level.MediumLevel;

public class TestMediumLevel {
	MediumLevel ml;

	
	@Before
	public void setUp() {
	      ml = new MediumLevel();
	   }
	
	@Test
	public void testLevel() {
		ml.getLevel();
		assertEquals("Medium", ml.getLevel());
	}
}
