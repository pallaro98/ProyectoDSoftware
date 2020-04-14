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
	private JLabel programLabel, durationLabel, timeLabel;

	Game game;
	public GameView(Game g) {
		game = g;
		setLayout(null);
		
		programLabel =new JLabel();
        programLabel.setText("Programa: " + g.getProgramLBL());
        programLabel.setBounds(10,20,480,50);
        add(programLabel);
        
        durationLabel =new JLabel();
        durationLabel.setText("Duración: " + g.getDurationLBL() + " Hrs");
        durationLabel.setBounds(10,70,480,50);
        add(durationLabel);
        
        timeLabel =new JLabel();
        timeLabel.setText("Tiempo Restante: " + g.getTime() + " Hrs");
        timeLabel.setBounds(10,120,480,50);
        add(timeLabel);
		
        botonadd=new JButton("Add");
        botonadd.setBounds(10,400,90,30);
        add(botonadd);
        botonadd.addActionListener(this);
        
        botonskip=new JButton("Skip");
        botonskip.setBounds(370,400,90,30);
        add(botonskip);
        botonskip.addActionListener(this);     
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		if(game.getAdvertencia() != "") {
			MaxHoursView maxHoursView = new MaxHoursView(game);
			maxHoursView.setBounds(0,0,500,150);
			maxHoursView.setVisible(true);
			maxHoursView.setTitle("Advertencia");
		} else {
			if(game.getTime()<=0) {
			
				ResultsView resultsView = new ResultsView(game);
				resultsView.setBounds(0,0,800,800);
				resultsView.setVisible(true);
				resultsView.setTitle("Streaming Content Game     " + game.getLevel() + game.getInitialT());
			} else {
				GameView gameView = new GameView(game);
				gameView.setBounds(0,0,500,500);
				gameView.setVisible(true);
				gameView.setTitle("Streaming Content Game     " + game.getLevel() + game.getInitialT());
			}
		}
		
		
		
	}
	
	void skipProgram(){
		this.setVisible(false);
		GameView gameView = new GameView(game);
		gameView.setBounds(0,0,500,500);
		gameView.setVisible(true);
		gameView.setTitle("Streaming Content Game     " + game.getLevel() + game.getInitialT());
	}
}
