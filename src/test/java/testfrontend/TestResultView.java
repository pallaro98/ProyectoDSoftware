package testfrontend;

import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.*;

import frontend.Constants;
import frontend.GameView;
import frontend.ResultsView;
import game.Game;
import level.BasicLevel;
import programs.Program;

public class TestResultView {
	Game g;
	Program p;
	ResultsView resultsView;
	
	@Before
	public void setUp() {
		
		g = new Game();
		p = new Program();
		g.getGameAttributes().setProgram(p);
		g.getGameAttributes().setInitialT(100.0);;
		g.setLevel("Basic");
	    g.getGameAttributes().setTime(100.0);
	    g.getAction().performAction(g.getGameAttributes(), "Adecuado", 100.0, new BasicLevel());
	    	    
	    
	    resultsView = new ResultsView(g);
        resultsView.setBounds(
                0,
                0,
                800,
                800
                );
        resultsView.setVisible(true);
        resultsView.setTitle(
                "Streaming Content Game     "
                        + g.getLevel()
                        + g.getGameAttributes().getInitialT()
                );
	}
	
	@Test
	public void testGame() {
		assertTrue(resultsView instanceof JFrame);
	}
	
}
