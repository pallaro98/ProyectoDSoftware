package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * MaxHoursView Class.
 * 
 */
public class MaxHoursView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	/**
	 * Botones.
	 * 
	 */
	private JButton  botonclose;
	/**
	 * Etiquetas.
	 * 
	 */
	private JLabel messageLabel;
	/**
	 * Juego actual.
	 * 
	 */
	private Game game;
	/**
	 * Constantes.
	 * 
	 */
	static final int	ZERO = 0, 
						TEN = 10, 
						TWENTY = 20, 
						THIRTY = 30, 
						FIFTY = 50,
						SIXTY = 60,
						SEVENTY = 70,
						NINETY = 90,
						ONEHUNDRED = 100,
						ONEHUNDREDTWENTY = 120,
						ONEHUNDREDFIFTY = 150,
						TWOHUNDRED = 200,
						TWOHUNDREDTHIRTY = 230,
						TWOHUNDREDNINETY = 290,
						THREEHUNDREDSEVENTY = 370,
						FOURHUNDRED = 400,
						FOURHUNDREDFIFTY = 450,
						FOURHUNDREDEIGHTY = 480,
						FIVEHUNDRED = 500,
						EIGHTHUNDRED = 800;
	/**
	 * constructor.
	 * @param g
	 * Juego actual.
	 */
	public MaxHoursView(final Game g) {
        setLayout(null);
        this.game = g;
        messageLabel = new JLabel();
        messageLabel.setText(
        		"Ya no puedes ver mas contenido de " 
        		+ game.getAdvertencia()
        );
        messageLabel.setBounds(
        		TEN,
        		TEN,
        		FOURHUNDREDFIFTY,
        		THIRTY
        );
        add(messageLabel);
        
        botonclose = new JButton(
        		"Regresar"
        );
        botonclose.setBounds(
        		TWOHUNDREDTHIRTY,
        		SIXTY,
        		NINETY,
        		THIRTY
        );
        add(botonclose);
        botonclose.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	/**
	 * acciones botones.
	 * @param e
	 * evento.
	 */
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == botonclose) {
			this.setVisible(false);
			game.setAdvertencia("");
			GameView gameView = new GameView(game);
			gameView.setBounds(
					ZERO,
					ZERO,
					FIVEHUNDRED,
					FIVEHUNDRED
			);
			gameView.setVisible(true);
			gameView.setTitle(
					"Streaming Content Game     " 
					+ game.getLevel() 
					+ game.getInitialT()
			);
		}      
    }
}