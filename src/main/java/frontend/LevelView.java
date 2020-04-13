package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import game.Game;

public class LevelView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JButton botonbasic, botonmedium, botonadvanced;
	private JLabel instructionslabel, l;
	
	Game game;
	
	public LevelView(Game g) {
		this.game = g;
        setLayout(null);
        
        //l = new JLabel("<html>Hello World!<br/>blahblahblah</html>", SwingConstants.CENTER);
        //l.setBounds(0,0,100,30);
        //add(l);
        
        instructionslabel = new JLabel();
        instructionslabel.setText("Seleccione el nivel en el que desea jugar:");
        instructionslabel.setBounds(10,20,400,50);
        add(instructionslabel);
        
        botonbasic = new JButton("Basic");
        botonbasic.setBounds(10,100,90,30);
        add(botonbasic);
        botonbasic.addActionListener(this);
        
        botonmedium = new JButton("Medium");
        botonmedium.setBounds(150,100,90,30);
        add(botonmedium);
        botonmedium.addActionListener(this);
        
        botonadvanced = new JButton("Advanced");
        botonadvanced.setBounds(290,100,90,30);
        add(botonadvanced);
        botonadvanced.addActionListener(this);        	
    }
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonbasic) {
            openSelectTime("Basic");
        }
        if (e.getSource() == botonmedium) {
        	openSelectTime("Medium");
        }
        if (e.getSource() == botonadvanced) {
        	openSelectTime("Advanced");
        }
    }
	
	public void openSelectTime(String s) {
		game.setLevel(s);
		
		this.setVisible(false);
		TimeView timeView = new TimeView(game);
		timeView.setBounds(0,0,400,200);
		timeView.setVisible(true);
    	timeView.setTitle("Streaming Content Game     " + game.getLevel());
	}
	
	
}
