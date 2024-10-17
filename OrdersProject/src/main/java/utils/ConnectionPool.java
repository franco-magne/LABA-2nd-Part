package utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final BasicDataSource dataSource;
    private static Properties properties;
    private static ConnectionPool connectionPool;

    public ConnectionPool() {
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("user"));
        dataSource.setPassword(properties.getProperty("password"));

        dataSource.setMinIdle(5); // Minimum inactive connections
        dataSource.setMaxIdle(10); // Maximum inactive connections
        dataSource.setMaxOpenPreparedStatements(100);
    }

    static {
        logger.info("Reading DB properties...");
        properties = new Properties();
        dataSource = new BasicDataSource();

        try (FileInputStream file = new FileInputStream("./src/main/resources/db.properties")) {
            properties.load(file);
        } catch (IOException e) {
            logger.error("Error reading the DB properties file");
        }
        logger.info("DB properties file successfully read!");
    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        ConnectionPool.properties = properties;
    }
}
