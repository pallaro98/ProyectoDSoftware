package actions;

import game.GameAttributes;
import level.Level;
import programs.Program;

public class ActionAdd implements Action {

    /***
     */
    private final int pct = 100;

    /***
     */
    private String name = "Add";

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
        addHashMap(cat, gameAttributes);

        if (gameAttributes.getCategoryCount().get(cat)
                + gameAttributes.getProgram().getDuration() <= pctCat) {

             if (gameAttributes.getTime()
                     >= gameAttributes.getProgram().getDuration()) {
                 viewProgram(cat,  gameAttributes.getProgram().getDuration(),
                         gameAttributes);
             } else {
                  viewProgram(cat, gameAttributes.getTime(), gameAttributes);
             }

        } else if (gameAttributes.getCategoryCount().get(cat) == pctCat) {
            gameAttributes.setAdvertencia(cat);
            return;
        } else {
             double n;
             n = (level.getCategory().get(cat)
                       .getMaxHr() / pct) * gameAttributes.getInitialT();

             double t;
             t = n - gameAttributes.getCategoryCount().get(cat)
                     < gameAttributes.getTime()
                     ? n - gameAttributes.getCategoryCount().get(cat)
                             : gameAttributes.getTime();

             viewProgram(cat, t, gameAttributes);
        }

        gameAttributes.getCategoryCount().forEach((k, v) ->
             System.out.println("Key: " + k
                       + " Hr:" + v + " MAX:"
                       + level.getCategory().get(cat)
                       .getMaxHr())
             );

        gameAttributes.getElections().add(gameAttributes.getProgram());
        gameAttributes.setUserIQ(gameAttributes.getUserIQ()
                + level.getCategory().get(cat).getMult()
                * gameAttributes.getProgram().getTiempoVisto());
    }

    /***
     * @param c {@link String}
     * @param gameAttributes {@link GameAttributes}
     */
    private void addHashMap(final String c,
                            final GameAttributes gameAttributes) {
        if (!gameAttributes.getCategoryCount().containsKey(c)) {
            gameAttributes.getCategoryCount().put(c, 0.0);
        }
    }

    /***
     * @param ct String
     * @param d double
     * @param gameAttributes {@link GameAttributes}
     */
    public final void viewProgram(final String ct,
            final double d, final GameAttributes gameAttributes) {
        gameAttributes.getProgram().setTiempoVisto(d);
        gameAttributes.setTime(gameAttributes.getTime()
                - gameAttributes.getProgram().getTiempoVisto());
        gameAttributes.getCategoryCount().put(ct, d
                + gameAttributes.getCategoryCount().get(ct));
    }

    /***
     * @param gameAttributes {@link GameAttributes}
     * @return gameAttributes.getProgram().getName() {@link String}
     */
    public final String getProgramLBL(final GameAttributes gameAttributes) {
         gameAttributes.setProgram(new Program());
         return gameAttributes.getProgram().getName();
    }

}
