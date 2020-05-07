package testgame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import game.Game;
import game.GameAttributes;
import level.BasicLevel;
import programs.Program;

public class TestGame {
	Game g;
	Program p;
	
	@Before
	public void setUp() {
			g = new Game();
			p = new Program();
			g.getGameAttributes().setProgram(p);
			g.setLevel("Basic");
			g.getGameAttributes().setTime(100.0);
		    g.getAction().performAction(g.getGameAttributes(), "Adecuado", 100.0, new BasicLevel());;
	   }
	
	@Test
	public void testGetProgram() {
		assertTrue(p == g.getGameAttributes().getProgram());
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
	
	@Test
	public void testActionDeletePerformAction() {
	    GameAttributes ga = Mockito.mock(GameAttributes.class);
	    Mockito.when(ga.getProgram()).thenReturn(p);
	    
	    HashMap<String, Double> h = new HashMap<String, Double>();
	    h.put("Adecuado", 10.0);
	    Mockito.when(ga.getCategoryCount()).thenReturn(h);
	    
	    g.changeAction();
        g.getAction().performAction(ga, "Adecuado", 100.0, new BasicLevel());;
	}
}
