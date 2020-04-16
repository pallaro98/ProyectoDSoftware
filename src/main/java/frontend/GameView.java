package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
/**
 * GameView Class.
*/
public class GameView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
     /**
      * botones.
      */

     private JButton botonadd;

     /***
      */
     private JButton botonskip;

     /**
      * labels.
      */
     private JLabel programLabel;

     /***
      */
     private JLabel durationLabel;

     /***
      */
     private JLabel timeLabel;

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
                    Constants.TEN,
                    Constants.TWENTY,
                    Constants.FOURHUNDREDEIGHTY,
                    Constants.FIFTY
                    );
          add(programLabel);
          durationLabel = new JLabel();
          durationLabel.setText(
                    "Duración: "
                    + g.getDurationLBL()
                    + " Hrs"
          );
          durationLabel.setBounds(
                    Constants.TEN,
                    Constants.SEVENTY,
                    Constants.FOURHUNDREDEIGHTY,
                    Constants.FIFTY
          );
          add(durationLabel);
          timeLabel = new JLabel();
          timeLabel.setText(
                    "Tiempo Restante: "
                    + g.getTime()
                    + " Hrs"
        );
        timeLabel.setBounds(
                  Constants.TEN,
                  Constants.ONEHUNDREDTWENTY,
                  Constants.FOURHUNDREDEIGHTY,
                  Constants.FIFTY
        );
        add(timeLabel);
        botonadd = new JButton("Add");
        botonadd.setBounds(
                  Constants.TEN,
                Constants.FOURHUNDRED,
                Constants.NINETY,
                Constants.THIRTY
        );
        add(botonadd);
        botonadd.addActionListener(this);
        botonskip = new JButton("Skip");
        botonskip.setBounds(
                  Constants.THREEHUNDREDSEVENTY,
                  Constants.FOURHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
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
                         Constants.ZERO,
                       Constants.ZERO,
                       Constants.FIVEHUNDRED,
                       Constants.ONEHUNDREDFIFTY
               );
               maxHoursView.setVisible(true);
               maxHoursView.setTitle("Advertencia");
          } else {
               if (game.getTime() <= 0) {
                    ResultsView resultsView = new ResultsView(game);
                    resultsView.setBounds(
                              Constants.ZERO,
                              Constants.ZERO,
                              Constants.EIGHTHUNDRED,
                              Constants.EIGHTHUNDRED
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
     }

     /**
      * saltar programa.
      */
     void skipProgram() {
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
