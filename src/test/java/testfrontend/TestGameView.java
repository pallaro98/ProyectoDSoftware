package testfrontend;

import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.*;

import frontend.GameView;
import game.Game;
import level.AdvanceLevel;
import programs.Program;

public class TestGameView {
	Game g;
	Program p;
	GameView gameView;
	
	@Before
	public void setUp() {
		
		g = new Game();
		p = new Program();
		g.setProgram(p);
		g.setLevel("Basic");
		g.setTime(100.0);
		g.addProgram();
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
	
}
