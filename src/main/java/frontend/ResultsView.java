package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * ResultsView Class.
 */
public class ResultsView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

     /**
      * Boton.
      */
     private JButton  botonclose;

     /**
      * Etiqueta.
      */
     private JLabel resultsLabel;

     /**
      * Etiqueta.
      */
     private JLabel iqLabel;

     /**
      * Etiqueta.
      */
     private JLabel categoriesLabel;

     /**
      * Juego actual.
      */
     private Game game;

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
                  + game.getGameAttributes().getUserIQ()
        );
        iqLabel.setBounds(
                  Constants.TEN,
                  Constants.TEN,
                  Constants.ONEHUNDREDFIFTY,
                  Constants.THIRTY
        );

        add(iqLabel);

        resultsLabel = new JLabel();
        resultsLabel.setText(g.getResultsLBL());
        resultsLabel.setBounds(
                  Constants.TEN,
                  Constants.SIXTY,
                  Constants.SEVENHUNDREDEIGHTY,
                  Constants.THREEHUNDRED
        );
        add(resultsLabel);

        categoriesLabel = new JLabel();
        categoriesLabel.setText(g.getPercentagesLBL());
        categoriesLabel.setBounds(
                  Constants.TEN,
                  Constants.FOURHUNDRED,
                  Constants.SEVENHUNDREDEIGHTY,
                  Constants.THREEHUNDRED
        );
        add(categoriesLabel);

        botonclose = new JButton("Close");
        botonclose.setBounds(
                  Constants.THREEHUNDREDFIFTY,
                  Constants.SEVENHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY);
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
