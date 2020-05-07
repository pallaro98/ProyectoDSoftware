package game;


import actions.Action;
import actions.ActionAdd;
import actions.ActionDelete;
import level.AdvanceLevel;
import level.FactoryLevel;
import level.Level;
import level.MediumLevel;
import programs.Program;

/***
 * @author Alessandro Pallaro & Hector Chavez
 */
public class Game {
    /***
     */
    private GameAttributes gameAttributes;

    /***
      */
     private final int pct = 100;

     /***
      *
      */
     private String result = "<html>Programas seleccionados:<br/>";

     /***
      */
     private String percentages = "<html>Porcentaje Categorias:<br/>";

     /***
      */
     private Level level;

     /***
      */
     private Action action;

     /***
      */
     private ActionAdd actionAdd;

     /***
      */
     private ActionDelete actionDelete;

     /***
      */
     public Game() {
         this.gameAttributes = new GameAttributes();
         this.actionDelete = new ActionDelete();
         this.actionAdd = new ActionAdd();

         this.action = actionAdd;
     }

     /***
      * @return String
      */
     public final String getLevel() {
          return this.level.getLevel();
     }

     /***
      * @param l String
      */
     public final void setLevel(final String l) {
          FactoryLevel fl = new FactoryLevel();
          this.level = fl.getLevel(l);
     }

     /***
      * @return Double
      */
     public final double getDurationLBL() {
          return gameAttributes.getProgram().getDuration();
     }

     /***
      * @return String
      */
     public final String getResultsLBL() {
          this.gameAttributes.getElections().forEach((p) -> {
               result = result.concat(
                         "Programa: " + p.getName()
                         + "-> Duraci�n: " + p.getTiempoVisto()
                         + "<br/>");
          });
          result = result.concat("</html>");

          System.out.println(result);
          System.out.println(gameAttributes.getUserIQ());
          return result;
     }

     /**
      * @return String
      */
     public final String getPercentagesLBL() {
         gameAttributes.getCategoryCount().forEach((k, v) -> {
             percentages = percentages.concat(
                     "Categoria: " + k + " -> "
                     + (v / gameAttributes.getInitialT()) * pct + "% <br/>");
          });
          percentages = percentages.concat("</html>");
          System.out.println(percentages);

          return  percentages;
     }

     /***
      * @return String
      */
     public final String getProgramCategoryLevel() {
          if (level instanceof AdvanceLevel) {
               return gameAttributes.getProgram().getCategoryadvanced();
          } else if (level instanceof MediumLevel) {
               return gameAttributes.getProgram().getCategorymedium();
          }

          return gameAttributes.getProgram().getCategorybasic();
     }

     /***
      * @param c String
      * @return double
      */
     public double getPrtCategory(final String c) {
         System.out.println(level.getCategory().get(c));
         return (level.getCategory().get(c).getMaxHr() / pct)
                 * gameAttributes.getInitialT();
     }

     /***
      */
     public final void performAction() {
         String cat = getProgramCategoryLevel();
         double pctCat = getPrtCategory(cat);
         action.performAction(gameAttributes, cat, pctCat, level);
     }

     /***
      * @param p Program
      * @return boolean
      */
     public boolean containsElection(final Program p) {
         return this.gameAttributes.getElections().contains(p);
     }

     /***
      * @return action {@link Action}
      */
     public Action getAction() {
         return this.action;
     }

     /***
      * @return gameAttributes {@link GameAttributes}
      */
     public GameAttributes getGameAttributes() {
         return this.gameAttributes;
     }

     /***
      */
     public void changeAction() {
         if (this.action == actionAdd) {
             if (!this.gameAttributes.getElections().isEmpty()) {
                 this.action = actionDelete;
             }
         } else {
             this.action = actionAdd;
             actionDelete.setI(1);
         }

         System.out.println(this.action.getName());
     }

     /***
      * @param ga {@link GameAttributes}
      */
     public final void setGameAttributes(final GameAttributes ga) {
         this.gameAttributes = ga;
     }

}
