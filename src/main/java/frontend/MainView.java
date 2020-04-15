package frontend;

import game.Game;
/**
 * MainView Class.
 * 
 */
public final class MainView {
	/**
	 * constructor.
	 */
	private MainView() {
	}
	/**
	 * Constantes.
	 * 
	 */
	static final int	ZERO = 0,
						TWOHUNDRED = 200,
						FOURHUNDRED = 400;

	/**
	 * Main.
	 * @param args
	 * args.
	 */
	public static void main(final String[] args) {
		Game g = new Game();
		LevelView levelView = new LevelView(g);
		levelView.setBounds(
				ZERO,
				ZERO,
				FOURHUNDRED,
				TWOHUNDRED
		);
		levelView.setVisible(true);
		levelView.setTitle(
				"Streaming Content Game"
		);
	}
}
