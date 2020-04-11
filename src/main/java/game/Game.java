package game;

import java.util.ArrayList;

import level.FactoryLevel;
import level.Level;
import programs.Program;

public class Game {
	Program program;
	double IQ = 0;
	ArrayList<Program> elections = new ArrayList<Program>();
	String level;
	Double time;
	String result = "";
	Level levelLevel;
	
	public double getIQ() {
		return this.IQ;
	}
	
	public String getLevel() {
		return this.level;
	}
	
	public double getTime() {
		return this.time;
	}
	
	public void setLevel(String l) {
		this.level = l;
		FactoryLevel fl = new FactoryLevel();
		this.levelLevel = fl.getLevel(l);
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
		System.out.println(IQ);
		return result;
	}
	
	public void addProgram() {
		this.elections.add(program);
		this.time -= program.getDuration();
		
		switch(level) {
		case "Basic":
			this.IQ += this.levelLevel.getCategory().get(program.getCategorybasic()) * program.getDuration();
			break;
		case "Medium":
			this.IQ += this.levelLevel.getCategory().get(program.getCategorymedium()) * program.getDuration();
			break;
		case "Advanced":
			this.IQ += this.levelLevel.getCategory().get(program.getCategoryadvanced())* program.getDuration();
			break;
		}

	}

}
