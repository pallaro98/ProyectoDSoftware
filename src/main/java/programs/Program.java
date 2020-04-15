package programs;

import mongoDBclient.MongoDB;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * Program Class.
 * 
 */
public class Program {	
	/**
	 * Tiempo de duracion del programa.
	 * 
	 */
	private double duration;
	/**
	 * tiempo que se vio del programa.
	 * 
	 */
	private double tiempoVisto;
	/**
	 * Nombre del programa.
	 * 
	 */
	private String name;
	/**
	 * Categoria para nivel Basico.
	 * 
	 */
	private String categorybasic;
	/**
	 * Categoria para nivel Intermedio.
	 * 
	 */
	private String categorymedium;
	/**
	 * Categoria para nivel Avanzado.
	 * 
	 */
	private String categoryadvanced;
	
	/**
	 * constructor.
	 */
	public Program() {
		MongoDatabase db = MongoDB.getInstance();
		MongoCollection<Document> collection = 
				db.getCollection("programas");
		
		int selection = (int) (
				Math.random() 
				* collection.countDocuments()
		);

		Document query = new Document("number", selection);
		Document result = collection.find(query).iterator().next();
		
		this.name = result.getString("name");
		this.categorybasic = result.getString("categorybasic");
		this.categorymedium = result.getString("categorymedium");
		this.categoryadvanced = result.getString("categoryadvanced");
		this.duration = result.getDouble("duration");
	}
	
	/**
	 * getName.
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * getCategorybasic.
	 * @return String
	 */
	public String getCategorybasic() {
		return this.categorybasic;
	}
	/**
	 * getCategorymedium.
	 * @return String
	 */
	public String getCategorymedium() {
		return this.categorymedium;
	}
	/**
	 * getCategoryadvanced.
	 * @return String
	 */
	public String getCategoryadvanced() {
		return this.categoryadvanced;
	}
	/**
	 * getDuration.
	 * @return Double
	 */
	public Double getDuration() {
		return this.duration;
	}
	/**
	 * setTiempoVisto.
	 * @param tv
	 * Tiempo visto.
	 */
	public void setTiempoVisto(final double tv) {
		this.tiempoVisto = tv;
	}
	/**
	 * getTiempoVisto.
	 * @return Double
	 */
	public double getTiempoVisto() {
		return this.tiempoVisto;
	}
}