package actions;

import game.GameAttributes;
import level.Level;
import programs.Program;

public class ActionDelete implements Action {

    /***
     */
    private String name = "Delete";

    /***
     */
    private int i = 1;

    /***
     * @return i {@link Integer}
     */
    public int getI() {
        return this.i;
    }

    /***
     * @param val {@link Integer}
     */
    public void setI(final int val) {
        this.i = val;
    }

    /***
     * @return name {@link String}
     */
    public String getName() {
        return this.name;
    }

    /***
     * @param gameAttributes {@link GameAttributes}
     * @param cat {@link String}
     * @param pctCat {@link Double}
     * @param level {@link Level}
     */
    public void performAction(final GameAttributes gameAttributes,
            final String cat, final double pctCat, final Level level) {
        gameAttributes.setTime(gameAttributes.getTime()
                + gameAttributes.getProgram().getTiempoVisto());
        gameAttributes.getElections().remove(gameAttributes.getProgram());
        gameAttributes.setUserIQ(gameAttributes.getUserIQ()
                - (gameAttributes.getProgram().getTiempoVisto()
                        * level.getCategory().get(cat).getMult()));
        gameAttributes.getCategoryCount().replace(cat,
                gameAttributes.getCategoryCount().get(cat)
                - gameAttributes.getProgram().getTiempoVisto());
        i--;
    }

    /***
     * @param gameAttributes {@link GameAttributes}
     * @return gameAttributes.getProgram().getName() {@link String}
     */
    public String getProgramLBL(final GameAttributes gameAttributes) {
        if (gameAttributes.getElections().isEmpty()) {
            gameAttributes.setProgram(Program.getProgramaDefault());
            return "Ya no hay mas programas para borrar, cambia de modo";
        }

        gameAttributes.setProgram(gameAttributes.getElections().get(
                gameAttributes.getElections().size() - i));

        if (i < gameAttributes.getElections().size()) {
            i++;
        }

        return gameAttributes.getProgram().getName();
    }

}
