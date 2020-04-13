package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;

public class MaxHoursView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton  botonclose;
	private JLabel messageLabel;
	private Game game;
	
	public MaxHoursView(Game g) {
        setLayout(null);
        this.game = g;
        messageLabel = new JLabel();
        messageLabel.setText("Ya no puedes ver mas contenido de " + game.getAdvertencia());
        messageLabel.setBounds(10,10,450,30);
        add(messageLabel);
        
        botonclose = new JButton("Regresar");
        botonclose.setBounds(230,60,90,30);
        add(botonclose);
        botonclose.addActionListener(this);
    }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonclose) {
			this.setVisible(false);
			game.setAdvertencia("");
			GameView gameView = new GameView(game);
			gameView.setBounds(0,0,500,500);
			gameView.setVisible(true);
			gameView.setTitle("Streaming Content Game     " + game.getLevel() + game.getInitialT());
		}      
    }
}
