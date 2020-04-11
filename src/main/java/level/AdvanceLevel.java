package level;

import java.util.HashMap;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import mongoDBclient.MongoDB;

public class AdvanceLevel implements Level {
	private HashMap<String, Integer> categories;

	public AdvanceLevel() {
		this.categories = new HashMap<String, Integer>();
		setCategory();
	}
	
	private void setCategory() {
		MongoDatabase db = MongoDB.getInstance();
		MongoCollection<Document> collection = db.getCollection("categoryAdvance");
		MongoCursor<Document> cursor = collection.find().iterator();
		
		while(cursor.hasNext()) {
			Document d = cursor.next();
			this.categories.put(d.getString("category"), d.getInteger("mult"));
		}

	}
	
	public HashMap<String, Integer> getCategory() {
		return this.categories;
	}

}
