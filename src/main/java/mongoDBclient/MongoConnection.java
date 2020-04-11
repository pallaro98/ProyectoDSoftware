package mongoDBclient;

import org.bson.Document;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	public static Document getProgram(int number) {
		MongoDatabase db = MongoDB.getInstance();
		
		
		//probar
		MongoCollection<Document> collection = db.getCollection("programas");
		//Document query = new Document("_id", new ObjectId("5e8ea3c81c9d4400004272f8"));
		//Document result = collection.find(query).iterator().next();
		
		Document query = new Document("number", number);
		Document result = collection.find(query).iterator().next();

		//System.out.println(result.getString("Titulo"));
		MongoDB.closeInstance();
		return result;
	}

}
