package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import model.Store;

public class StoreJAXB {
    private static final Logger logger = LogManager.getLogger(StoreJAXB.class);

    public static void marshal(Store store, String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Store.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(store, new File(path));

            logger.info(store.toString() + " correctly marshalled.");
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Store unmarshal(String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Store.class);
            Store store = (Store) ctx.createUnmarshaller().unmarshal(new File(path));
            logger.info(store.toString() + " correctly unmarshalled.");

            return store;
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
