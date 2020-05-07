package testfrontend;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import frontend.TimeView;
import game.Game;
import level.BasicLevel;
import programs.Program;

public class TestTimeView {
    Game g;
    Program p;
    TimeView timeview;
    
    @Before
    public void setUp() {
        g = new Game();
        p = new Program();
        g.getGameAttributes().setProgram(p);
        g.getGameAttributes().setInitialT(100.0);;
        g.setLevel("Basic");
        g.getGameAttributes().setTime(100.0);
        g.getAction().performAction(g.getGameAttributes(), "Adecuado", 100.0, new BasicLevel());;
        timeview = new TimeView(g);
        timeview.setBounds(
            0,
            0,
            500,
            500
        );
        timeview.setVisible(true);
    }
    
    @Test
    public void testGame() {
        assertTrue(timeview instanceof JFrame);
    }
    
    @Test
    public void testActionPerformed1() {
        ActionEvent e = Mockito.mock(ActionEvent.class);
        Mockito.when(e.getSource()).thenReturn(timeview.getBoton100());
        
        timeview.actionPerformed(e);
        assertTrue(timeview.bWorked());
    }
    
    @Test
    public void testActionPerformed2() {
        ActionEvent e = Mockito.mock(ActionEvent.class);
        Mockito.when(e.getSource()).thenReturn(timeview.getBoton200());
            
        timeview.actionPerformed(e);
        assertTrue(timeview.bWorked());
    }
    
    @Test
    public void testActionPerformed3() {
        ActionEvent e = Mockito.mock(ActionEvent.class);
        Mockito.when(e.getSource()).thenReturn(timeview.getBoton300());
                
        timeview.actionPerformed(e);
        assertTrue(timeview.bWorked());
    }
    
}
