package dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConnectionPool;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO {
    protected static final Logger logger = LogManager.getLogger(AbstractDAO.class);

    public AbstractDAO() {}

    public static Connection getConnection() throws SQLException {
        return ConnectionPool.getInstance().getConnection();
    }

}
