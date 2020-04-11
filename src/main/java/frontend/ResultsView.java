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
	private JLabel resultslabel, iqLabel ;
	Game game;
	
	public ResultsView(Game g) {
		game = g;
        setLayout(null);
        
        resultslabel = new JLabel();
        resultslabel.setText(g.getResultsLBL());
        resultslabel.setBounds(0,0,200,200);
        add(resultslabel);
        
        
        iqLabel = new JLabel();
        iqLabel.setText("Tu IQ fue de: " + game.getIQ());
        iqLabel.setBounds(0,100,200,200);
        add(iqLabel);
        
        botonclose = new JButton("Close");
        botonclose.setBounds(110,100,90,30);
        add(botonclose);
        botonclose.addActionListener(this);
    }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonclose) {
			this.setVisible(false);
		}      
    }
	
	
	
	
}
