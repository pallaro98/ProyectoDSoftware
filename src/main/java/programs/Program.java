package programs;

import mongoDBclient.MongoDB;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Program {
	double duration;
	double tiempoVisto;
	String name;
	String categorybasic;
	String categorymedium;
	String categoryadvanced;
	
	public Program() {
		MongoDatabase db = MongoDB.getInstance();
		MongoCollection<Document> collection = db.getCollection("programas");
		int selection = (int) (Math.random() * collection.countDocuments());

		Document query = new Document("number", selection);
		Document result = collection.find(query).iterator().next();
		
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
	
	public void setTiempoVisto(double tv) {
		this.tiempoVisto = tv;
	}
	
	public double getTiempoVisto() {
		return this.tiempoVisto;
	}
}
