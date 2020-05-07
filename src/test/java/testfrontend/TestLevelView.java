package testfrontend;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import frontend.LevelView;
import game.Game;
import level.BasicLevel;
import programs.Program;

public class TestLevelView {
    Game g;
    Program p;
    LevelView levelView;
    
    @Before
    public void setUp() {
        
        g = new Game();
        p = new Program();
        g.getGameAttributes().setProgram(p);
        g.getGameAttributes().setInitialT(100.0);;
        g.setLevel("Basic");
        g.getGameAttributes().setTime(100.0);
        g.getAction().performAction(g.getGameAttributes(), "Adecuado", 100.0, new BasicLevel());;
        levelView = new LevelView(g);
        levelView.setBounds(
            0,
            0,
            500,
            500
        );
        levelView.setVisible(true);
    }
    
    @Test
    public void testGame() {
        assertTrue(levelView instanceof JFrame);
    }
    
    @Test
    public void testActionPerformed1() {
        ActionEvent e = Mockito.mock(ActionEvent.class);
        Mockito.when(e.getSource()).thenReturn(levelView.getBotonBasic());
        
        levelView.actionPerformed(e);
        assertTrue(levelView.bWorked());
    }
    
    @Test
    public void testActionPerformed2() {
        ActionEvent e = Mockito.mock(ActionEvent.class);
        Mockito.when(e.getSource()).thenReturn(levelView.getBotonMedium());
            
        levelView.actionPerformed(e);
        assertTrue(levelView.bWorked());
    }
    
    @Test
    public void testActionPerformed3() {
        ActionEvent e = Mockito.mock(ActionEvent.class);
        Mockito.when(e.getSource()).thenReturn(levelView.getBotonAdvanced());
                
        levelView.actionPerformed(e);
        assertTrue(levelView.bWorked());
    }
    
}

