package level;

import java.util.HashMap;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import category.Category;
import mongoDBclient.MongoDB;

/***
 * @author Pallaro & Hector
 */
public class AdvanceLevel implements Level {

	/***
	 */
	private String level;

	/***
	 */
	private HashMap<String, Category> categories;

	/***
	 */
	public AdvanceLevel() {
		this.categories = new HashMap<String, Category>();
		this.level = "Advanced";
		setCategory();
	}

	/***
	 */
	private void setCategory() {
		MongoDatabase db = MongoDB.getInstance();
		MongoCollection<Document> collection;
		collection = db.getCollection("categoryAdvance");

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
	public final HashMap<String, Category> getCategory() {
		return this.categories;
	}

	/***
	 * @return String
	 */
	public final String getLevel() {
		return this.level;
	}

}
