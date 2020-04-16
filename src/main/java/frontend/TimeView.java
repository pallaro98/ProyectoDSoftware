package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * TimeView Class.
 */
public class TimeView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

     /**
      * Boton.
      */
     private JButton  boton100h;

     /**
      * Boton.
      */
     private JButton  boton200h;

     /**
      * Boton.
      */
     private JButton  boton300h;

     /**
      * Etiquetas.
      */
     private JLabel instructionslabel;

     /**
      * Juego actual.
      */
     private Game game;

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
                  Constants.TEN,
                  Constants.TWENTY,
                  Constants.FOURHUNDRED,
                  Constants.FIFTY
        );
        add(instructionslabel);

        boton100h = new JButton("100");
        boton100h.setBounds(
                  Constants.TEN,
                  Constants.ONEHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
        );
        add(boton100h);
        boton100h.addActionListener(this);

        boton200h = new JButton("200");
        boton200h.setBounds(
                  Constants.ONEHUNDREDFIFTY,
                  Constants.ONEHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
        );
        add(boton200h);
        boton200h.addActionListener(this);

        boton300h = new JButton("300");
        boton300h.setBounds(
                  Constants.TWOHUNDREDNINETY,
                  Constants.ONEHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
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
            openGame(Constants.ONEHUNDRED);
        }
        if (e.getSource() == boton200h) {
            openGame(Constants.TWOHUNDRED);
        }
        if (e.getSource() == boton300h) {
            openGame(Constants.THREEHUNDRED);
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
                    Constants.ZERO,
                    Constants.ZERO,
                    Constants.FIVEHUNDRED,
                    Constants.FIVEHUNDRED
          );
          gameView.setVisible(true);
          gameView.setTitle(
                    "Streaming Content Game     "
                    + game.getLevel()
                    + game.getInitialT()
          );
    }
}
