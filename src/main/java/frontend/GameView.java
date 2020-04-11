package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;

public class GameView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton botonadd, botonskip;
	private JLabel programlabel;

	Game game;
	public GameView(Game g) {
		game = g;
		setLayout(null);
        botonadd=new JButton("Add");
        botonadd.setBounds(10,100,90,30);
        add(botonadd);
        botonadd.addActionListener(this);
        
        botonskip=new JButton("Skip");
        botonskip.setBounds(210,100,90,30);
        add(botonskip);
        botonskip.addActionListener(this);     
        
        programlabel =new JLabel();
        programlabel.setText(g.getProgramLBL());
        programlabel.setBounds(10,20,200,50);
        add(programlabel);
    }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonadd) {
            addProgram();
        } 
        if (e.getSource()==botonskip) {
            skipProgram();
        }       
    }
	
	void addProgram(){
		
		this.setVisible(false);
		
		game.addProgram();
		if(game.getTime()<=0) {
			ResultsView resultsView = new ResultsView(game);
			resultsView.setBounds(0,0,350,200);
			resultsView.setVisible(true);
			resultsView.setTitle(game.getLevel() + game.getTime());
		}else {
			GameView gameView = new GameView(game);
			gameView.setBounds(0,0,350,200);
			gameView.setVisible(true);
			gameView.setTitle(game.getLevel() + game.getTime());
		}
		
		
	}
	
	void skipProgram(){
		this.setVisible(false);
		GameView gameView = new GameView(game);
		gameView.setBounds(0,0,350,200);
		gameView.setVisible(true);
		gameView.setTitle(game.getLevel() + game.getTime());
	}
}
