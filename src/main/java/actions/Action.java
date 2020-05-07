package actions;

import game.GameAttributes;
import level.Level;

public interface Action {
	public String getName();
	
	public void performAction(GameAttributes gameAttributes, String cat, double pctCat, Level level, int pct);
	public String getProgramLBL(GameAttributes gameAttributes);
}
