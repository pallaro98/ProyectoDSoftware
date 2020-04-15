package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;

/**
 * LevelView Class.
 * 
 */
public class LevelView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	/**
	 * botones.
	 * 
	 */
	private JButton botonbasic, botonmedium, botonadvanced;
	
	/**
	 * etiquetas.
	 * 
	 */
	private JLabel instructionslabel;
	
	/**
	 * Constantes.
	 * 
	 */
	static final int	ZERO = 0, 
						TEN = 10, 
						TWENTY = 20, 
						THIRTY = 30, 
						FIFTY = 50,
						SEVENTY = 70,
						NINETY = 90,
						ONEHUNDRED = 100,
						ONEHUNDREDTWENTY = 120,
						ONEHUNDREDFIFTY = 150,
						TWOHUNDRED = 200,
						TWOHUNDREDNINETY = 290,
						THREEHUNDREDSEVENTY = 370,
						FOURHUNDRED = 400,
						FOURHUNDREDEIGHTY = 480,
						FIVEHUNDRED = 500,
						EIGHTHUNDRED = 800;
	
	/**
	 * juego.
	 */
	private Game game;
	
	/**
	 * constructor.
	 * @param g
	 * Juego actual.
	 */
	public LevelView(final Game g) {
		this.game = g;
        setLayout(null);
        
        instructionslabel = new JLabel();
        instructionslabel.setText(
        		"Seleccione el nivel en el que desea jugar:"
        );
        instructionslabel.setBounds(
        		TEN,
        		TWENTY,
        		FOURHUNDRED,
        		FIFTY
        );
        add(instructionslabel);
        
        botonbasic = new JButton("Basic");
        botonbasic.setBounds(
        		TEN,
        		ONEHUNDRED,
        		NINETY,
        		THIRTY
        );
        add(botonbasic);
        botonbasic.addActionListener(this);
        
        botonmedium = new JButton("Medium");
        botonmedium.setBounds(
        		ONEHUNDREDFIFTY,
        		ONEHUNDRED,
        		NINETY,
        		THIRTY
        );
        add(botonmedium);
        botonmedium.addActionListener(this);
        
        botonadvanced = new JButton("Advanced");
        botonadvanced.setBounds(
        		TWOHUNDREDNINETY,
        		ONEHUNDRED,
        		NINETY,
        		THIRTY
        );
        add(botonadvanced);
        botonadvanced.addActionListener(this);        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	/**
	 * acciones botones.
	 * @param e
	 * evento.
	 */
	public void actionPerformed(final ActionEvent e) {
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
	
	/**
	 * abrir siguiente vista.
	 * @param s
	 * nivel.
	 */
	public void openSelectTime(final String s) {
		game.setLevel(s);
		
		this.setVisible(false);
		TimeView timeView = new TimeView(game);
		timeView.setBounds(
				ZERO,
				ZERO,
				FOURHUNDRED,
				TWOHUNDRED
		);
		timeView.setVisible(true);
    	timeView.setTitle(
    			"Streaming Content Game     " 
    			+ game.getLevel()
    	);
	}
}