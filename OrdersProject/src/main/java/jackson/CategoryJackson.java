package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class CategoryJackson {
    private static final Logger logger = LogManager.getLogger(CategoryJackson.class);

    public static void convertToJSON(Category category, String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            writer.writeValue(file, category);
            logger.info(category.toString() + " converted to JSON");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Category convertToObject(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            Category category = mapper.readValue(file, Category.class);
            logger.info(category.toString() + " converted to Object");

            return category;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
