package level;

import java.util.HashMap;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import category.Category;
import mongoDBclient.MongoDB;

public class AdvanceLevel implements Level {
	private String level;
	private HashMap<String, Category> categories;

	public AdvanceLevel() {
		this.categories = new HashMap<String, Category>();
		this.level = "Advanced";
		setCategory();
	}
	
	private void setCategory() {
		MongoDatabase db = MongoDB.getInstance();
		MongoCollection<Document> collection = db.getCollection("categoryAdvance");
		MongoCursor<Document> cursor = collection.find().iterator();
		
		while(cursor.hasNext()) {
			Category c = new Category();
			Document d = cursor.next();
			c.setMult(d.getInteger("mult"));
			c.setMaxHr(d.getDouble("maxHr"));
			this.categories.put(d.getString("category"), c);
		}

	}
	
	public HashMap<String, Category> getCategory() {
		return this.categories;
	}

	public String getLevel() {
		return this.level;
	}

}
