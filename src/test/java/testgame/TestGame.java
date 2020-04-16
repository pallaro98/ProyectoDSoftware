package testgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


import game.Game;
import programs.Program;

public class TestGame {
	Game g;
	Program p;
	

	
	@Before
	public void setUp() {
			g = new Game();
			p = new Program();
			g.setProgram(p);
			g.setLevel("Basic");
			g.setTime(100.0);
			g.addProgram();
	   }
	
	@Test
	public void testGetProgram() {
		assertTrue(p == g.getProgram());
	}
	
	@Test
	public void testAddProgram() {
		assertTrue((g.containsElection(p)));
	}
	
	@Test
	public void testGetResults() {
		String s = g.getResultsLBL();
		assertTrue((s.contains(p.getName())));
	}
	
	
	
	
}
