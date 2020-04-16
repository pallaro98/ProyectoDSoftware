package testmongo;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import com.mongodb.client.MongoDatabase;

import mongoDBclient.MongoDB;

public class TestMongoDB {
	
	MongoDatabase mongoA;
	MongoDatabase mongoB;

	@Test
	public void testClose() {
		mongoA = MongoDB.getInstance();
		MongoDB.closeInstance();
		mongoB = MongoDB.getInstance();
		assertTrue((mongoA != mongoB));
	}
	

}
