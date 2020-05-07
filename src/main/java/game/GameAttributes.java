package game;

import java.util.ArrayList;
import java.util.HashMap;

import programs.Program;

public class GameAttributes {
    /***
     */
    private HashMap<String, Double> categoryCount;

    /***
     */
    private ArrayList<Program> elections;

    /***
     */
    private Program program;

    /***
     */
    private Double time;

    /***
     */
    private String advertencia = "";

    /***
     */
    private double userIQ = 0;

    /***
     */
    private Double initialT;

    /***
     */
    public GameAttributes() {
        this.elections = new ArrayList<Program>();
        this.categoryCount = new HashMap<String, Double>();
    }

    /***
     * @param t {@link Double}
     */
    public void setTime(final Double t) {
        this.time = t;
    }

    /**
     * @return initialT {@link Double}
     */
    public final Double getInitialT() {
        return this.initialT;
    }

    /***
     * @return categoryCount HashMap<String, Double>
     */
    public HashMap<String, Double> getCategoryCount() {
        return categoryCount;
    }

    /***
     * @param cc {@link HashMap}
     */
    public void setCategoryCount(final HashMap<String, Double> cc) {
        this.categoryCount = cc;
    }

    /***
     * @return elections {@link ArrayList}
     */
    public ArrayList<Program> getElections() {
        return elections;
    }

    /***
     * @param e {@link ArrayList}
     */
    public void setElections(final ArrayList<Program> e) {
        this.elections = e;
    }

    /***
     * @return program {@link Program}
     */
    public Program getProgram() {
        return program;
    }

    /***
     * @param p {@link Program}
     */
    public void setProgram(final Program p) {
        this.program = p;
    }

    /***
     * @return time {@link Double}
     */
    public Double getTime() {
        return time;
    }

    /***
     * @param t {@link Double}
     */
    public void setInitialT(final Double t) {
        this.time = t;
        this.initialT = t;
    }

    /***
     * @return advertencia {@link String}
     */
    public String getAdvertencia() {
        return advertencia;
    }

    /***
     * @param a {@link String}
     */
    public void setAdvertencia(final String a) {
        this.advertencia = a;
    }

    /***
     * @return userIQ {@link Double}
     */
    public double getUserIQ() {
        return userIQ;
    }

    /***
     * @param uiq {@link Double}
     */
    public void setUserIQ(final double uiq) {
        this.userIQ = uiq;
    }

}
