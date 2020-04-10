package mongoDBclient;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	private static MongoDatabase database;
	private static MongoClient mongoClient;
	private MongoDB() {
		MongoClientURI uri = new MongoClientURI(
			    "mongodb+srv://admin:admin@cluster0-len75.mongodb.net/test?retryWrites=true&w=majority");

		mongoClient = new MongoClient(uri);
		database = mongoClient.getDatabase("database");
	}
	
	public static MongoDatabase getInstance() {
		if(database==null) {
			new MongoDB();
		}
		return database;
	}
	
	public static void closeInstance() {
		if(database != null) {
			mongoClient.close();
			database = null;
		}
	}
}
