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

    /***
     */
    private boolean bWorked = false;

     /**
      * botones.
      */

     private JButton botonaction;

     /**
      * botones.
      */

     private JButton botoncambiaraccion;

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
                  + g.getAction().getProgramLBL(g.getGameAttributes())
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
                    + g.getGameAttributes().getTime()
                    + " Hrs"
        );
        timeLabel.setBounds(
                  Constants.TEN,
                  Constants.ONEHUNDREDTWENTY,
                  Constants.FOURHUNDREDEIGHTY,
                  Constants.FIFTY
        );
        add(timeLabel);
        botonaction = new JButton(g.getAction().getName());
        botonaction.setBounds(
                  Constants.TEN,
                Constants.FOURHUNDRED,
                Constants.NINETY,
                Constants.THIRTY
        );
        add(botonaction);
        botonaction.addActionListener(this);
        botonskip = new JButton("Skip");
        botonskip.setBounds(
                  Constants.THREEHUNDREDSEVENTY,
                  Constants.FOURHUNDRED,
                  Constants.NINETY,
                  Constants.THIRTY
        );
        add(botonskip);
        botonskip.addActionListener(this);

        botoncambiaraccion = new JButton("change");
        botoncambiaraccion.setBounds(
                  Constants.ZERO,
                  Constants.ZERO,
                  Constants.NINETY,
                  Constants.THIRTY
        );
        add(botoncambiaraccion);
        botoncambiaraccion.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
     }

     /**
      * acciones botones.
      * @param e
      * evento.
      */
     public void actionPerformed(final ActionEvent e) {
          if (e.getSource() == botonaction) {
              bWorked = true;
               performAction();
          }

          if (e.getSource() == botonskip) {
              bWorked = true;
               skipProgram();
          }

          if (e.getSource() == botoncambiaraccion) {
              bWorked = true;
              changeAction();
         }
     }

     /**
      * cambiar accion.
      */
     void changeAction() {
         game.changeAction();
         skipProgram();
     }
     /**
      * agregar programa.
      */
     void performAction() {
         System.out.println("kpedo");
         this.setVisible(false);
         game.performAction();
         if (game.getGameAttributes().getAdvertencia() != "") {
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
             if (game.getGameAttributes().getTime() <= 0) {
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
                                 + game.getGameAttributes().getInitialT()
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
                                 + game.getGameAttributes().getInitialT()
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
                         + game.getGameAttributes().getInitialT()
                 );
     }

     /***
      * @return botonaction {@link JButton}
      */
     public JButton getBotonAction() {
         return this.botonaction;
     }

     /***
      * @return botonskip {@link JButton}
      */
     public JButton getBotonSkip() {
         return this.botonskip;
     }

     /***
      * @return botoncambiaraccion {@link JButton}
      */
     public JButton getChangeAction() {
         return this.botoncambiaraccion;
     }

     /***
      * @return bWorked {@link Boolean}
      */
     public boolean bWorked() {
         return this.bWorked;
     }

}
