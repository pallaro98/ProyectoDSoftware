package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;

/**
 * LevelView Class.
 */
public class LevelView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

     /**
      * botones.
      */
     private JButton botonbasic;

     /***
      */
     private JButton botonmedium;

     /***
      */
     private JButton botonadvanced;

     /**
      * etiquetas.
      */
     private JLabel instructionslabel;

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
                  Constants.TEN,
                  Constants.TWENTY,
                  Constants.FOURHUNDRED,
                  Constants.FIFTY
        );
        add(instructionslabel);

        botonbasic = new JButton("Basic");
        botonbasic.setBounds(
                  Constants.TEN,
                  Constants.ONEHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
        );
        add(botonbasic);
        botonbasic.addActionListener(this);

        botonmedium = new JButton("Medium");
        botonmedium.setBounds(
                  Constants.ONEHUNDREDFIFTY,
                  Constants.ONEHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
        );
        add(botonmedium);
        botonmedium.addActionListener(this);

        botonadvanced = new JButton("Advanced");
        botonadvanced.setBounds(
                  Constants.TWOHUNDREDNINETY,
                  Constants.ONEHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
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
                    Constants.ZERO,
                    Constants.ZERO,
                    Constants.FOURHUNDRED,
                    Constants.TWOHUNDRED
          );
          timeView.setVisible(true);
         timeView.setTitle(
                   "Streaming Content Game     "
                   + game.getLevel()
         );
     }
}
