package programs;

import mongoDBclient.MongoConnection;

import org.bson.Document;

public class Program {
	double duration;
	String name;
	String categorybasic;
	String categorymedium;
	String categoryadvanced;
	
	public Program() {
		int selection = (int) (Math.random()*3);
		Document result = MongoConnection.getProgram(selection);
		this.name = result.getString("name");
		this.categorybasic = result.getString("categorybasic");
		this.categorymedium = result.getString("categorymedium");
		this.categoryadvanced = result.getString("categoryadvanced");
		this.duration = result.getDouble("duration");
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCategorybasic() {
		return this.categorybasic;
	}
	
	public String getCategorymedium() {
		return this.categorymedium;
	}
	
	public String getCategoryadvanced() {
		return this.categoryadvanced;
	}
	
	public Double getDuration() {
		return this.duration;
	}
}
