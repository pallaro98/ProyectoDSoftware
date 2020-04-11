package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import game.Game;

public class LevelView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton botonbasic, botonmedium, botonadvanced;
	Game game;
	
	public LevelView(Game g) {
		this.game = g;
        setLayout(null);
        botonbasic=new JButton("Basic");
        botonbasic.setBounds(10,100,90,30);
        add(botonbasic);
        botonbasic.addActionListener(this);
        botonmedium=new JButton("Medium");
        botonmedium.setBounds(110,100,90,30);
        add(botonmedium);
        botonmedium.addActionListener(this);
        botonadvanced=new JButton("Advanced");
        botonadvanced.setBounds(210,100,90,30);
        add(botonadvanced);
        botonadvanced.addActionListener(this);        	
    }
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource()==botonbasic) {
            openSelectTime("Basic");
        }
        if (e.getSource()==botonmedium) {
        	openSelectTime("Medium");
        }
        if (e.getSource()==botonadvanced) {
        	openSelectTime("Advanced");
        }
    }
	
	public void openSelectTime(String s) {
		game.setLevel(s);
		
		this.setVisible(false);
		TimeView timeView = new TimeView(game);
		timeView.setBounds(0,0,350,200);
		timeView.setVisible(true);
    	timeView.setTitle(game.getLevel());;
	}
	
	
}
