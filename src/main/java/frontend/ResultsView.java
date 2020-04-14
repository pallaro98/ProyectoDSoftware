package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;

public class ResultsView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton  botonclose;
	private JLabel resultsLabel, iqLabel, categoriesLabel;
	Game game;
	
	public ResultsView(Game g) {
		game = g;
        setLayout(null);
        
        iqLabel = new JLabel();
        iqLabel.setText("Tu nuevo IQ fue de: " + game.getIQ());
        iqLabel.setBounds(10,10,150,30);
        add(iqLabel);
        
        resultsLabel = new JLabel();
        resultsLabel.setText(g.getResultsLBL());
        resultsLabel.setBounds(10,60,780,300);
        add(resultsLabel);
        
        categoriesLabel = new JLabel();
        categoriesLabel.setText(g.getPercentagesLBL());
        categoriesLabel.setBounds(10,400,780,300);
        add(categoriesLabel);
        
        botonclose = new JButton("Close");
        botonclose.setBounds(350,700,90,30);
        add(botonclose);
        botonclose.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonclose) {
			this.setVisible(false);
			System.exit(1);
		}      
    }
}
