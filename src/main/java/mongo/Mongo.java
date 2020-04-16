package mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/***
 * @author Pallaro & Hector
 */
public final class Mongo {

    /***
      */
     private static MongoDatabase database;

     /***
      */
     private static MongoClient mongoClient;

     /***
      */
     private Mongo() {
          MongoClientURI uri = new MongoClientURI(
               "mongodb+srv://admin:admin@cluster0-len75"
               + ".mongodb.net/test?retryWrites=true&w=majority");

          mongoClient = new MongoClient(uri);
          database = mongoClient.getDatabase("database");
     }

     /***
      * @return MongoDatabase
      */
     public static MongoDatabase getInstance() {
          if (database == null) {
               new Mongo();
          }
          return database;
     }

     /***
      */
     public static void closeInstance() {
          if (database != null) {
               mongoClient.close();
               database = null;
          }
     }
}
