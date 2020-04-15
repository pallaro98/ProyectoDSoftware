package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * TimeView Class.
 * 
 */
public class TimeView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	/**
	 * Botones.
	 * 
	 */
	private JButton  boton100h, boton200h, boton300h;
	/**
	 * Etiquetas.
	 * 
	 */
	private JLabel instructionslabel;
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
						THREEHUNDRED = 300,
						THREEHUNDREDFIFTY = 350,
						THREEHUNDREDSEVENTY = 370,
						FOURHUNDRED = 400,
						FOURHUNDREDFIFTY = 450,
						FOURHUNDREDEIGHTY = 480,
						FIVEHUNDRED = 500,
						SEVENHUNDRED = 700,
						SEVENHUNDREDEIGHTY = 780,
						EIGHTHUNDRED = 800;
	/**
	 * constructor.
	 * @param g
	 * Juego actual.
	 */
	public TimeView(final Game g) {
		game = g;
        setLayout(null);
        
        instructionslabel = new JLabel();
        instructionslabel.setText(
        		"Seleccione el tiempo de contenido que desea ver:"
        );
        instructionslabel.setBounds(
        		TEN,
        		TWENTY,
        		FOURHUNDRED,
        		FIFTY
        );
        add(instructionslabel);
        
        boton100h = new JButton("100");
        boton100h.setBounds(
        		TEN,
        		ONEHUNDRED,
        		NINETY,
        		THIRTY
        );
        add(boton100h);
        boton100h.addActionListener(this);
        
        boton200h = new JButton("200");
        boton200h.setBounds(
        		ONEHUNDREDFIFTY,
        		ONEHUNDRED,
        		NINETY,
        		THIRTY
        );
        add(boton200h);
        boton200h.addActionListener(this);
        
        boton300h = new JButton("300");
        boton300h.setBounds(
        		TWOHUNDREDNINETY,
        		ONEHUNDRED,
        		NINETY,
        		THIRTY
        );
        add(boton300h);
        boton300h.addActionListener(this);   
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
	/**
	 * acciones botones.
	 * @param e
	 * evento.
	 */
	public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == boton100h) {
            openGame(ONEHUNDRED);
        } 
        if (e.getSource() == boton200h) {
            openGame(TWOHUNDRED);
        }
        if (e.getSource() == boton300h) {
            openGame(THREEHUNDRED);
        }     
    }
	/**
	 * acciones botones.
	 * @param i
	 * tiempo.
	 */
	public void openGame(final double i) {
		game.setTime(i);
		
		this.setVisible(false);
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