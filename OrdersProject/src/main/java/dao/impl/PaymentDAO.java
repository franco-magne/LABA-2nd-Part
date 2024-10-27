package dao.impl;

import dao.DAO;
import model.Payment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO extends AbstractDAO implements DAO<Payment> {

    public PaymentDAO() {}

    @Override
    public Payment getByID(int id) {
        String sqlQuery = "SELECT * FROM payment WHERE (idPayment = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Payment(
                    rs.getInt("idPayment"),
                    rs.getString("method")
                );
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> paymentList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM payment";

        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                paymentList.add(new Payment(
                   rs.getInt("idPayment"),
                   rs.getString("method")
                ));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return paymentList;
    }

    @Override
    public void insert(Payment obj) {
        String sqlQuery = "INSERT INTO payment(name) VALUES (?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getMethod());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(Payment obj) {
        String sqlQuery = "UPDATE payment SET method = ? WHERE (idPayment = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getMethod());
            stmt.setInt(2, obj.getIdPayment());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void delete(Payment obj) {
        String sqlQuery = "DELETE FROM payment WHERE (idPayment = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getIdPayment());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

}
