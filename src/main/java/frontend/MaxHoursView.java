package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * MaxHoursView Class.
 */
public class MaxHoursView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

     /**
      * Botones.
      */
     private JButton  botonclose;

     /**
      * Etiquetas.
      */
     private JLabel messageLabel;

     /**
      * Juego actual.
      */
     private Game game;

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
                  + game.getGameAttributes().getAdvertencia()
        );
        messageLabel.setBounds(
                  Constants.TEN,
                  Constants.TEN,
                  Constants.FOURHUNDREDFIFTY,
                  Constants.THIRTY
        );
        add(messageLabel);

        botonclose = new JButton(
                  "Regresar"
        );
        botonclose.setBounds(
                  Constants.TWOHUNDREDTHIRTY,
                  Constants.SIXTY,
                  Constants.NINETY,
                  Constants.THIRTY
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
               game.getGameAttributes().setAdvertencia("");
               GameView gameView = new GameView(game);
               gameView.setBounds(
                         Constants.ZERO,
                         Constants.ZERO,
                         Constants.FIVEHUNDRED,
                         Constants.FIVEHUNDRED
               );
               gameView.setVisible(true);
               gameView.setTitle(
                         "Streaming Content Game     "
                         + game.getLevel()
                         + game.getGameAttributes().getInitialT()
               );
          }
    }
}
