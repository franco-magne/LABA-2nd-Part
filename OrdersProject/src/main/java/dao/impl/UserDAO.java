package dao.impl;

import dao.DAO;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements DAO<User> {

    public UserDAO() {}

    @Override
    public User getByID(int id) {
        String sqlQuery = "SELECT * FROM user WHERE (idUser = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("idUser"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        new CountryDAO().getByID(rs.getInt("idCountry"))
                );
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM user";

        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                userList.add(new User(
                        rs.getInt("idUser"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        new CountryDAO().getByID(rs.getInt("idCountry"))
                ));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return userList;
    }

    @Override
    public void insert(User obj) {
        String sqlQuery = "INSERT INTO user (firstName, lastName, " +
                "email, address, phoneNumber, idCountry) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getFirstName());
            stmt.setString(2, obj.getLastName());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getAddress());
            stmt.setString(5, obj.getPhoneNumber());
            stmt.setInt(6, obj.getCountry().getIdCountry());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(User obj) {
        String sqlQuery = "UPDATE user SET firstName = ?, lastName = ?, " +
                "email = ?, address = ?, phoneNumber = ?, idCountry = ? WHERE (idUser = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getFirstName());
            stmt.setString(2, obj.getLastName());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getAddress());
            stmt.setString(5, obj.getPhoneNumber());
            stmt.setInt(6, obj.getCountry().getIdCountry());
            stmt.setInt(7, obj.getIdUser());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void delete(User obj) {
        String sqlQuery = "DELETE FROM user WHERE (idUser = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getIdUser());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }


}
