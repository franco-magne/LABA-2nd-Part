package dao.impl;

import dao.DAO;
import model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractDAO implements DAO<Order> {

    public OrderDAO() {}

    @Override
    public Order getByID(int id) {
        String sqlQuery = "SELECT * FROM order WHERE (idOrder = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Order(
                    rs.getInt("idOrder"),
                    new UserDAO().getByID(rs.getInt("idUser")),
                    rs.getDouble("totalPrice"),
                    rs.getDate("orderDate"),
                    new PaymentDAO().getByID(rs.getInt("idPayment")),
                    rs.getBoolean("isPaid")
                );
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM order";

        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                orderList.add(new Order(
                   rs.getInt("idOrder"),
                   new UserDAO().getByID(rs.getInt("idUser")),
                   rs.getDouble("totalPrice"),
                   rs.getDate("orderDate"),
                   new PaymentDAO().getByID(rs.getInt("idPayment")),
                   rs.getBoolean("isPaid")
                ));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return orderList;
    }

    @Override
    public void insert(Order obj) {
        String sqlQuery = "INSERT INTO order (idUser, totalPrice, orderDate, idPayment, isPaid) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getUser().getIdUser());
            stmt.setDouble(2, obj.getTotalPrice());
            stmt.setString(3, obj.getStringOrderDate());
            stmt.setInt(4, obj.getPayment().getIdPayment());
            stmt.setBoolean(5, obj.getIsPaid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(Order obj) {
        String sqlQuery = "UPDATE order SET idUser = ?, totalPrice = ?, orderDate = ?, idPayment = ?, isPaid = ? " +
                "WHERE (idOrder = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getUser().getIdUser());
            stmt.setDouble(2, obj.getTotalPrice());
            stmt.setString(3, obj.getStringOrderDate());
            stmt.setInt(4, obj.getPayment().getIdPayment());
            stmt.setBoolean(5, obj.getIsPaid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void delete(Order obj) {
        String sqlQuery = "DELETE FROM order WHERE (idOrder = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getIdOrder());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

}
