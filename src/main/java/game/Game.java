package game;

import java.util.ArrayList;
import java.util.HashMap;

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
     private final int pct = 100;

     /***
      */
     private double userIQ = 0;

     /***
      */
     private ArrayList<Program> elections;

     /***
      */
     private HashMap<String, Double> categoryCount;

     /***
      */
     private Double time;

     /***
      */
     private Double initialT;

     /***
      *
      */
     private String result = "<html>Programas seleccionados:<br/>";

     /***
      */
     private String percentages = "<html>Porcentaje Categorias:<br/>";

     /***
      */
     private String advertencia = "";

     /***
      */
     private Program program;

     /***
      */
     private Level level;

     /***
      */
     public Game() {
          this.elections = new ArrayList<Program>();
          this.categoryCount = new HashMap<String, Double>();
     }

     /***
      * @return double
      */
     public final double getIQ() {
          return this.userIQ;
     }

     /***
      * @return String
      */
     public final String getLevel() {
          return this.level.getLevel();
     }

     /***
      * @return double
      */
     public final double getTime() {
          return this.time;
     }

     /***
      * @return double
      */
     public final double getInitialT() {
          return this.initialT;
     }

     /***
      * @return String
      */
     public final String getAdvertencia() {
          return this.advertencia;
     }

     /***
      * @param a String
      */
     public final void setAdvertencia(final String a) {
          this.advertencia = a;
     }

     /***
      * @param l String
      */
     public final void setLevel(final String l) {
          FactoryLevel fl = new FactoryLevel();
          this.level = fl.getLevel(l);
     }

     /***
      * @param t double
      */
     public final void setTime(final Double t) {
          this.time = t;
          this.initialT = t;
     }

     /***
      * @return String
      */
     public final String getProgramLBL() {
          program = new Program();
          return program.getName();
     }

     /***
      * @return Double
      */
     public final double getDurationLBL() {
          return program.getDuration();
     }

     /***
      * @return String
      */
     public final String getResultsLBL() {
          this.elections.forEach((p) -> {
               result = result.concat(
                         "Programa: " + p.getName()
                         + "-> Duraci�n: " + p.getTiempoVisto()
                         + "<br/>");
          });
          result = result.concat("</html>");

          System.out.println(result);
          System.out.println(userIQ);
          return result;
     }

     /**
      * @return String
      */
     public final String getPercentagesLBL() {
          categoryCount.forEach((k, v) -> {
               percentages = percentages.concat(
                         "Categoria: " + k + " -> "
                         + (v / initialT) * pct + "% <br/>");
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
               return program.getCategoryadvanced();
          } else if (level instanceof MediumLevel) {
               return program.getCategorymedium();
          }

          return program.getCategorybasic();
     }

     /***
      * @param c String
      */
     private void addHashMap(final String c) {
          if (!categoryCount.containsKey(c)) {
               categoryCount.put(c, 0.0);
          }
     }

     /***
      * @param c String
      * @return double
      */
     public double getPrtCategory(final String c) {
    	 System.out.println(level.getCategory().get(c));
          return (level.getCategory().get(c).getMaxHr() / pct) * initialT;
     }

     /***
      */
     public final void addProgram() {
          String cat = getProgramCategoryLevel();
          addHashMap(cat);
          double pctCat = getPrtCategory(cat);

          if (categoryCount.get(cat) + program.getDuration() <= pctCat) {

               if (this.time >= program.getDuration()) {
                    viewProgram(cat,  program.getDuration());
               } else {
                    viewProgram(cat, this.time);
               }

          } else if (categoryCount.get(cat) == pctCat) {
               advertencia = cat;
               return;

          } else {
               double n;
               n = (level.getCategory().get(cat)
                         .getMaxHr() / pct) * initialT;

               double t;
               t = n - categoryCount.get(cat) < this.time
                    ? n - categoryCount.get(cat) : this.time;

               viewProgram(cat, t);
          }

          categoryCount.forEach((k, v) ->
               System.out.println("Key: " + k
                         + " Hr:" + v + " MAX:"
                         + level.getCategory().get(cat)
                         .getMaxHr())
               );

          this.elections.add(program);
          this.userIQ += this.level.getCategory().get(cat).getMult()
                    * program.getTiempoVisto();
     }

     /***
      * @param ct String
      * @param d double
      */
     public final void viewProgram(final String ct, final double d) {
          program.setTiempoVisto(d);
          this.time -= program.getTiempoVisto();

          categoryCount.put(ct, d + categoryCount.get(ct));
     }

     /***
      * @param p Program
      * @return boolean
      */
     public boolean containsElection(final Program p) {
         return this.elections.contains(p);
     }

     /***
     * @param p
     * programa.
     */
     public void setProgram(final Program p) {
         this.program = p;
     }

     /***
      * @return Program
      */
     public Program getProgram() {
         return this.program;
     }

}
