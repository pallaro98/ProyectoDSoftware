package game;

import java.util.ArrayList;

import programs.Program;

public class Game {
	static Program program;
	static double IQ = 0;
	ArrayList<Program> elections = new ArrayList<Program>();
	String level;
	Double time;
	String result = "";
	
	
	
	public String getLevel() {
		return this.level;
	}
	
	public double getTime() {
		return this.time;
	}
	
	public void setLevel(String l) {
		this.level = l;
	}
	
	public void setTime(Double t) {
		this.time = t;
	}
	
	public String getProgramLBL() {
		program = new Program();
		return "Programa: " + program.getName() + " Duración: " + program.getDuration();
	}
	
	public String getResultsLBL() {
		this.elections.forEach((p)->{
			result = result.concat("Programa: " + p.getName() + "-> Duración: " + p.getDuration());
		});
		System.out.println(result);
		return result;
	}
	
	public void addProgram() {
		this.elections.add(program);
		this.time -= program.getDuration();
		//this.IQ += ;
	}

}
