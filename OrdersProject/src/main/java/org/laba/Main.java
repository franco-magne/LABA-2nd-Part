package org.laba;

import dao.impl.CategoryDAO;
import model.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servicelayer.CategoryService;
import utils.xml.StAXParser;
import utils.xml.XMLValidator;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categoryList = categoryDAO.getAll();
        logger.info(categoryList);

        CategoryService categoryService = new CategoryService(categoryDAO);
        logger.info(categoryService.checkCategoryExists("Books"));

        String xsdPath = "src/main/resources/xsd/schema.xsd";
        String xmlPath = "src/main/resources/xml/schema.xml";
        XMLValidator.validateXMLSchemaWithXSD(xsdPath, xmlPath);

        StAXParser.parseXMLFileWithStAX(xmlPath);

    }
}
