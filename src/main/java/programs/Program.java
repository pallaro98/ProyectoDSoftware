package programs;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mongo.Mongo;
/**
 * Program Class.
 */
public class Program {

     /**
     * Tiempo de duracion del programa.
     */
    private double duration;

    /**
     * tiempo que se vio del programa.
     */
    private double tiempoVisto;

    /**
     * Nombre del programa.
     */
    private String name;

    /**
     * Categoria para nivel Basico.
     */
    private String categorybasic;

    /**
     * Categoria para nivel Intermedio.
     */
    private String categorymedium;

    /**
     * Categoria para nivel Avanzado.
     */
    private String categoryadvanced;
    
    /**
     * .
     */
    public static Program programaDefault = new Program(0.0, 0.0, "No hay más");

    
    /**
     * constructor.
     */
    public Program() {
        MongoDatabase db = Mongo.getInstance();
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
     * constructor.
     */
    public Program(Double d, double tv, String n) {
        this.duration = d;
        this.tiempoVisto = tv;
        this.name = n;
        this.categorybasic = "Adecuado";
        this.categorymedium = "Sexual";
        this.categoryadvanced = "Sexual";
        
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

    /**
    * setDuration.
    * @param d
    * duracion.
    */
    public void setDuration(final double d) {
        this.duration = d;
    }

    /**
    * setTName.
    * @param n
    * nombre.
    */
    public void setName(final String n) {
        this.name = n;
    }

    /**
    * setCategorybasic.
    * @param cat
    * categoria para nivel basico.
    */
    public void setCategorybasic(final String cat) {
        this.categorybasic = cat;
    }

    /**
    * setCategorymedium.
    * @param cat
    * categoria para nivel medio.
    */
    public void setCategorymedium(final String cat) {
        this.categorymedium = cat;
    }

    /**
    * setCategoryadvanced.
    * @param cat
    * categoria para nivel avanzado.
    */
    public void setCategoryadvanced(final String cat) {
        this.categoryadvanced = cat;
    }
}
