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
    
    public GameAttributes() {
    	this.elections = new ArrayList<Program>();
        this.categoryCount = new HashMap<String, Double>();
    }
    
    
    
    
    
    
    
    public void setTime(Double t) {
    	this.time = t;
    }
    
    public final Double getInitialT() {
        return this.initialT;
    }

	public HashMap<String, Double> getCategoryCount() {
		return categoryCount;
	}

	public void setCategoryCount(HashMap<String, Double> categoryCount) {
		this.categoryCount = categoryCount;
	}

	public ArrayList<Program> getElections() {
		return elections;
	}

	public void setElections(ArrayList<Program> elections) {
		this.elections = elections;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Double getTime() {
		return time;
	}

	public void setInitialT(Double t) {
		this.time = t;
		this.initialT = t;
	}

	public String getAdvertencia() {
		return advertencia;
	}

	public void setAdvertencia(String advertencia) {
		this.advertencia = advertencia;
	}

	public double getUserIQ() {
		return userIQ;
	}

	public void setUserIQ(double userIQ) {
		this.userIQ = userIQ;
	}
    
    
}
