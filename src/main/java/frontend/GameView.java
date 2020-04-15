package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * GameView Class.
 * 
 */
public class GameView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	/**
	 * botones.
	 * 
	 */
	private JButton botonadd, botonskip;
	/**
	 * etiquetas.
	 * 
	 */
	private JLabel programLabel, durationLabel, timeLabel;
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
						ONEHUNDREDTWENTY = 120,
						ONEHUNDREDFIFTY = 150,
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
	public GameView(final Game g) {
		game = g;
		setLayout(null);
		programLabel = new JLabel();
		programLabel.setText(
				"Programa: " 
        		+ g.getProgramLBL()
		);
		programLabel.setBounds(
				TEN, 
        		TWENTY, 
        		FOURHUNDREDEIGHTY, 
        		FIFTY
        );
		add(programLabel);
        durationLabel = new JLabel();
        durationLabel.setText(
        		"Duración: " 
        		+ g.getDurationLBL() 
        		+ " Hrs"
        );
        durationLabel.setBounds(
        		TEN, 
        		SEVENTY, 
        		FOURHUNDREDEIGHTY, 
        		FIFTY
        );
        add(durationLabel);
        timeLabel = new JLabel();
        timeLabel.setText(
        		"Tiempo Restante: " 
        		+ g.getTime() 
        		+ " Hrs"
        );
        timeLabel.setBounds(
        		TEN, 
        		ONEHUNDREDTWENTY, 
        		FOURHUNDREDEIGHTY, 
        		FIFTY
        );
        add(timeLabel);
        botonadd = new JButton("Add");
        botonadd.setBounds(
        		TEN, 
        		FOURHUNDRED, 
        		NINETY, 
        		THIRTY
        );
        add(botonadd);
        botonadd.addActionListener(this);
        botonskip = new JButton("Skip");
        botonskip.setBounds(
        		THREEHUNDREDSEVENTY, 
        		FOURHUNDRED, 
        		NINETY, 
        		THIRTY
        );
        add(botonskip);
        botonskip.addActionListener(this);     
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/**
	 * acciones botones.
	 * @param e
	 * evento.
	 */
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == botonadd) {
			addProgram();
		}
		if (e.getSource() == botonskip) {
			skipProgram();
		}    
	}
	/**
	 * agregar programa.
	 */
	void addProgram() {
		this.setVisible(false);
		game.addProgram();
		if (game.getAdvertencia() != "") {
			MaxHoursView maxHoursView = new MaxHoursView(game);
			maxHoursView.setBounds(
					ZERO, 
					ZERO, 
					FIVEHUNDRED, 
					ONEHUNDREDFIFTY
			);
			maxHoursView.setVisible(true);
			maxHoursView.setTitle("Advertencia");
		} else {
			if (game.getTime() <= 0) {
				ResultsView resultsView = new ResultsView(game);
				resultsView.setBounds(
						ZERO, 
						ZERO, 
						EIGHTHUNDRED, 
						EIGHTHUNDRED
				);
				resultsView.setVisible(true);
				resultsView.setTitle(
						"Streaming Content Game     " 
						+ game.getLevel() 
						+ game.getInitialT()
				);
			} else {
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
	/**
	 * saltar programa.
	 */
	void skipProgram() {
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
