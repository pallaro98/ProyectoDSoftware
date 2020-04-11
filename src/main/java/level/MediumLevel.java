package level;

import java.util.HashMap;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import mongoDBclient.MongoDB;

public class MediumLevel implements Level {
	private HashMap<String, Integer> categories;

	public MediumLevel() {
		categories = new HashMap<String, Integer>();
		setCategory();
	}
	
	private void setCategory() {
		MongoDatabase db = MongoDB.getInstance();
		MongoCollection<Document> collection = db.getCollection("categoryMedium");
		MongoCursor<Document> cursor = collection.find().iterator();
		
		while(cursor.hasNext()) {
			Document d = cursor.next();
			this.categories.put(d.getString("category"), d.getInteger("mult"));
		}

	}
	
	public HashMap<String, Integer> getCategory() {
		return categories;
	}

}
