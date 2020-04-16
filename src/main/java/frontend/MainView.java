package frontend;

import game.Game;
/**
 * MainView Class.
 */

public final class MainView {
    /**
      * constructor.
      */
     private MainView() {
     }

     /**
      * Main.
      * @param args
      * args.
      */
     public static void main(final String[] args) {
          Game g = new Game();
          LevelView levelView = new LevelView(g);
          levelView.setBounds(
                    Constants.ZERO,
                    Constants.ZERO,
                    Constants.FOURHUNDRED,
                    Constants.TWOHUNDRED
          );
          levelView.setVisible(true);
          levelView.setTitle(
                    "Streaming Content Game"
          );
     }
}
