package testmongo;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import com.mongodb.client.MongoDatabase;

import mongo.Mongo;

public class TestMongoDB {
	
	MongoDatabase mongoA;
	MongoDatabase mongoB;

	@Test
	public void testClose() {
		mongoA = Mongo.getInstance();
		Mongo.closeInstance();
		mongoB = Mongo.getInstance();
		assertTrue((mongoA != mongoB));
	}
	

}
