package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

public class UserJAXB {
    private static final Logger logger = LogManager.getLogger(UserJAXB.class);

    public static void marshal(User user, String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(User.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(user, new File(path));

            logger.info(user.toString() + " correctly marshalled.");
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static User unmarshal(String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(User.class);
            User user = (User) ctx.createUnmarshaller().unmarshal(new File(path));
            logger.info(user.toString() + " correctly unmarshalled.");

            return user;
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
