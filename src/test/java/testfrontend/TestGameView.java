package testfrontend;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import org.junit.*;
import org.mockito.Mockito;

import frontend.GameView;
import game.Game;
import level.BasicLevel;
import programs.Program;

public class TestGameView {
	Game g;
	Program p;
	GameView gameView;
	
	@Before
	public void setUp() {
		
		g = new Game();
		p = new Program();
		g.getGameAttributes().setProgram(p);
		g.getGameAttributes().setInitialT(100.0);;
		g.setLevel("Basic");
	    g.getGameAttributes().setTime(100.0);
	    g.getAction().performAction(g.getGameAttributes(), "Adecuado", 100.0, new BasicLevel());;
		gameView = new GameView(g);
		gameView.setBounds(
			0,
			0,
			500,
			500
		);
		gameView.setVisible(true);
	}
	
	@Test
	public void testGame() {
		assertTrue(gameView instanceof JFrame);
	}
	
	@Test
	public void testActionPerformed1() {
	    ActionEvent e = Mockito.mock(ActionEvent.class);
	    Mockito.when(e.getSource()).thenReturn(gameView.getBotonAction());
	    
	    gameView.actionPerformed(e);
	    assertTrue(gameView.bWorked());
    }
	
	@Test
	public void testActionPerformed2() {
	    ActionEvent e = Mockito.mock(ActionEvent.class);
	    Mockito.when(e.getSource()).thenReturn(gameView.getBotonSkip());
	        
	    gameView.actionPerformed(e);
	    assertTrue(gameView.bWorked());
	}
	
	@Test
	public void testActionPerformed3() {
	    ActionEvent e = Mockito.mock(ActionEvent.class);
	    Mockito.when(e.getSource()).thenReturn(gameView.getChangeAction());
	            
	    gameView.actionPerformed(e);
	    assertTrue(gameView.bWorked());
	}
	
}
