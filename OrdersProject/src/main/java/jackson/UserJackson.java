package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class UserJackson {
    private static final Logger logger = LogManager.getLogger(UserJackson.class);

    public static void convertToJSON(User user, String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            writer.writeValue(file, user);
            logger.info(user.toString() + " converted to JSON");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static User convertToObject(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(file, User.class);
            logger.info(user.toString() + " converted to Object");

            return user;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
