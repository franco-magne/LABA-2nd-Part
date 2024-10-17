package utils.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;

public class StAXParser {
    private static final Logger logger = LogManager.getLogger(StAXParser.class);

    public static void parseXMLFileWithStAX(String xmlPath) {
        logger.info("Parsing the following xml file: " + xmlPath);
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();

            FileInputStream fileInputStream = new FileInputStream(xmlPath);
            XMLEventReader eventReader = factory.createXMLEventReader(fileInputStream);

            String currentElement = "";
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    currentElement = startElement.getName().getLocalPart();
                }

                if (event.isCharacters()) {
                    Characters characters = event.asCharacters();
                    if (!characters.isWhiteSpace()) {
                        switch (currentElement) {
                            case "idCategory":
                                logger.info("ID Category: " + characters.getData());
                                break;
                            case "name":
                                logger.info("Name: " + characters.getData());
                                break;
                            case "idCountry":
                                logger.info("ID Country: " + characters.getData());
                                break;
                            case "idPayment":
                                logger.info("ID Payment: " + characters.getData());
                                break;
                            case "method":
                                logger.info("Method: " + characters.getData());
                                break;
                            case "idUser":
                                logger.info("ID User: " + characters.getData());
                                break;
                            case "firstName":
                                logger.info("First Name: " + characters.getData());
                                break;
                            case "lastName":
                                logger.info("Last Name: " + characters.getData());
                                break;
                            case "email":
                                logger.info("Email: " + characters.getData());
                                break;
                            case "address":
                                logger.info("Address: " + characters.getData());
                                break;
                            case "phoneNumber":
                                logger.info("Phone Number: " + characters.getData());
                                break;
                            case "idStore":
                                logger.info("ID Store: " + characters.getData());
                                break;
                            case "reputation":
                                logger.info("Reputation: " + characters.getData());
                                break;
                        }
                    }
                }
            }
            eventReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
