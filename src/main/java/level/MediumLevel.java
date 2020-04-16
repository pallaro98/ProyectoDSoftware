package level;

import java.util.HashMap;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import category.Category;
import mongo.Mongo;

/***
 * @author Pallaro & Hector
 */
public class MediumLevel implements Level {

    /***
      */
     private String level;

     /***
      */
     private HashMap<String, Category> categories;

     /***
      */
     public MediumLevel() {
          categories = new HashMap<String, Category>();
          this.level = "Medium";
          setCategory();
     }

     /***
      */
     private void setCategory() {
          MongoDatabase db = Mongo.getInstance();
          MongoCollection<Document> collection;
          collection = db.getCollection("categoryMedium");

          MongoCursor<Document> cursor = collection.find().iterator();

          while (cursor.hasNext()) {
               Category c = new Category();
               Document d = cursor.next();
               c.setMult(d.getInteger("mult"));
               c.setMaxHr(d.getDouble("maxHr"));
               this.categories.put(d.getString("category"), c);
          }

     }

     /***
      * @return HashMap<String, Category>
      */
     public HashMap<String, Category> getCategory() {
          return categories;
     }

     /***
      * @return String
      */
     public String getLevel() {
          return this.level;
     }

}
