package actions;

import game.GameAttributes;
import level.Level;

public interface Action {
    /***
     * @return {@link String}
     */
    String getName();

    /***
     * @param gameAttributes
     * @param cat
     * @param pctCat
     * @param level
     */
    void performAction(GameAttributes gameAttributes, String cat,
                        double pctCat, Level level);

    /***
     * @param gameAttributes
     * @return {@link String}
     */
    String getProgramLBL(GameAttributes gameAttributes);
}
