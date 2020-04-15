package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * ResultsView Class.
 * 
 */
public class ResultsView extends JFrame implements ActionListener {
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
	private JLabel resultsLabel, iqLabel, categoriesLabel;
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
	public ResultsView(final Game g) {
		game = g;
        setLayout(null);
        
        iqLabel = new JLabel();
        iqLabel.setText(
        		"Tu nuevo IQ fue de: " 
        		+ game.getIQ()
        );
        iqLabel.setBounds(
        		TEN,
        		TEN,
        		ONEHUNDREDFIFTY,
        		THIRTY
        );
        
        add(iqLabel);
        
        resultsLabel = new JLabel();
        resultsLabel.setText(g.getResultsLBL());
        resultsLabel.setBounds(
        		TEN,
        		SIXTY,
        		SEVENHUNDREDEIGHTY,
        		THREEHUNDRED
        );
        add(resultsLabel);
        
        categoriesLabel = new JLabel();
        categoriesLabel.setText(g.getPercentagesLBL());
        categoriesLabel.setBounds(
        		TEN,
        		FOURHUNDRED,
        		SEVENHUNDREDEIGHTY,
        		THREEHUNDRED
        );
        add(categoriesLabel);
        
        botonclose = new JButton("Close");
        botonclose.setBounds(
        		THREEHUNDREDFIFTY,
        		SEVENHUNDRED,
        		NINETY,
        		THIRTY);
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
			System.exit(1);
		}      
    }
}
