package mongoDBclient;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	public static void main(String[] args) {
		MongoClientURI uri = new MongoClientURI(
			    "mongodb+srv://admin:admin@cluster0-len75.mongodb.net/test?retryWrites=true&w=majority");

		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("database");

		//probar
		MongoCollection<Document> collection = database.getCollection("programas");
		Document query = new Document("_id", new ObjectId("5e8ea3c81c9d4400004272f8"));
		Document result = collection.find(query).iterator().next();

		System.out.println(result.getString("Titulo"));
		mongoClient.close();
	}

}
