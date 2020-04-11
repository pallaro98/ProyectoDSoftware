package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import game.Game;

public class TimeView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton  boton100h, boton200h, boton300h;
	Game game;
	public TimeView(Game g) {
		game = g;
        setLayout(null);
        boton100h=new JButton("100");
        boton100h.setBounds(10,100,90,30);
        add(boton100h);
        boton100h.addActionListener(this);
        boton200h=new JButton("200");
        boton200h.setBounds(110,100,90,30);
        add(boton200h);
        boton200h.addActionListener(this);
        boton300h=new JButton("300");
        boton300h.setBounds(210,100,90,30);
        add(boton300h);
        boton300h.addActionListener(this);        	
    }
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton100h) {
            openGame(100);
            
        } 
        if (e.getSource()==boton200h) {
            openGame(200);

        }
        if (e.getSource()==boton300h) {
            openGame(300);
        }     
    }
	
	public void openGame(double i){
		game.setTime(i);
		
		this.setVisible(false);
		GameView gameView = new GameView(game);
		gameView.setBounds(0,0,350,200);
		gameView.setVisible(true);
		gameView.setTitle(game.getLevel() + game.getTime());;
    }
}
