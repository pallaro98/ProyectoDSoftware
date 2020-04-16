package level;

import java.util.HashMap;

import category.Category;

/***
 * @author Pallaro & Hector
 */
public interface Level {

    /***
      * @return String
      */
     String getLevel();

     /***
      * @return HashMap<String, Category>
      */
     HashMap<String, Category> getCategory();
}
