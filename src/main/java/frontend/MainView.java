package frontend;

import game.Game;


public class MainView {

	public static void main(String[] args) {
		Game g = new Game();
		LevelView levelView = new LevelView(g);
		levelView.setBounds(0,0,400,200);
		levelView.setVisible(true);
		levelView.setTitle("Streaming Content Game");
	}

}
