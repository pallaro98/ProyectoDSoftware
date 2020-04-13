package game;

import java.util.ArrayList;
import java.util.HashMap;

import frontend.MaxHoursView;
import level.AdvanceLevel;
import level.FactoryLevel;
import level.Level;
import level.MediumLevel;
import programs.Program;

public class Game {
	Program program;
	double IQ = 0;
	ArrayList<Program> elections = new ArrayList<Program>();
	HashMap<String, Double> categoryCount = new HashMap<String, Double>();
	Double time;
	Double initialT;
	String result = "<html>Programas seleccionados:<br/>";
	String percentages = "<html>Porcentaje Categorias:<br/>";
	Level level;
	String advertencia = "";
	
	public double getIQ() {
		return this.IQ;
	}
	
	public String getLevel() {
		return this.level.getLevel();
	}
	
	public double getTime() {
		return this.time;
	}
	
	public double getInitialT() {
		return this.initialT;
	}
	
	public String getAdvertencia() {
		return this.advertencia;
	}
	
	public void setAdvertencia(String a) {
		this.advertencia = a;
	}
	
	public void setLevel(String l) {
		FactoryLevel fl = new FactoryLevel();
		this.level = fl.getLevel(l);
	}
	
	public void setTime(Double t) {
		this.time = t;
		this.initialT = t;
	}
	
	public String getProgramLBL() {
		program = new Program();
		return program.getName();
	}
	
	public Double getDurationLBL() {
		return program.getDuration();
	}
	
	public String getResultsLBL() {
		this.elections.forEach((p)->{
			result = result.concat("Programa: " + p.getName() + "-> Duraci�n: " + p.getTiempoVisto() + "<br/>");
		});
		result = result.concat("</html>");
		
		System.out.println(result);
		System.out.println(IQ);
		return result;
	}
	
	public String getPercentagesLBL() {
		categoryCount.forEach((k, v) ->{
			percentages = percentages.concat("Categoria: " + k + " -> " + (v / initialT) * 100 + "%" + "<br/>");
		});
		
		percentages = percentages.concat("</html>");

		System.out.println(percentages);
		
		return  percentages;
	}
	
	public String getProgramCategoryLevel() {
		if(level instanceof AdvanceLevel) return program.getCategoryadvanced();
		else if(level instanceof MediumLevel) return program.getCategorymedium();	
		
		return program.getCategorybasic();
	}
	
	public void addProgram() {
		String cat = getProgramCategoryLevel();			
		
		if(categoryCount.containsKey(cat)) {
			if(categoryCount.get(cat) + program.getDuration() <= (level.getCategory().get(cat).getMaxHr()/100) * initialT) {
				if(this.time >= program.getDuration()) {
					viewProgram(cat,  program.getDuration(), categoryCount.get(cat));
				}
				
				else {
					viewProgram(cat, this.time, categoryCount.get(cat));
				}
			}
			
			else if(categoryCount.get(cat) == (level.getCategory().get(cat).getMaxHr()/100) * initialT) {
				advertencia = cat;
				return;
			}
			
			else {
				double t = (level.getCategory().get(cat).getMaxHr()/100) * initialT - categoryCount.get(cat) < this.time? (level.getCategory().get(cat).getMaxHr()/100) * initialT - categoryCount.get(cat): this.time;
				
				viewProgram(cat, t, categoryCount.get(cat));
			}
			
		}
		
		else {			
			if(this.time >= program.getDuration()) {
				viewProgram(cat, program.getDuration(), 0.0);
			}
			
			else {
				viewProgram(cat, this.time, 0.0);
			}
		}
		System.out.println("-------------------------");
		categoryCount.forEach((k, v) -> System.out.println("Key: " + k +" Hr:" + v + " MAX:" + level.getCategory().get(cat).getMaxHr()));
		this.elections.add(program);
		this.IQ += this.level.getCategory().get(cat).getMult() * program.getTiempoVisto();
	}
	
	public void viewProgram(String ct, double d, double d2) {
		program.setTiempoVisto(d);
		this.time -= program.getTiempoVisto();
		
		categoryCount.put(ct, d + d2);
	}
	
}
