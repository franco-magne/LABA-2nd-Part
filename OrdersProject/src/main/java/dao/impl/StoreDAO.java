package dao.impl;

import dao.DAO;
import model.Store;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO extends AbstractDAO implements DAO<Store> {

    public StoreDAO() {}

    @Override
    public Store getByID(int id) {
        String sqlQuery = "SELECT * FROM store WHERE (idStore = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Store(
                        rs.getInt("idStore"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getInt("reputation"),
                        new CountryDAO().getByID(rs.getInt("idCountry"))
                );
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Store> getAll() {
        List<Store> storeList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM store";

        try (Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                storeList.add(new Store(
                    rs.getInt("idStore"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getInt("reputation"),
                    new CountryDAO().getByID(rs.getInt("idCountry"))
                ));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return storeList;
    }

    @Override
    public void insert(Store obj) {
        String sqlQuery = "INSERT INTO store (name, address, reputation, idCountry) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getAddress());
            stmt.setInt(3, obj.getReputation());
            stmt.setInt(4, obj.getCountry().getIdCountry());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(Store obj) {
        String sqlQuery = "UPDATE store SET name = ?, address = ?, reputation = ?, idCountry = ? WHERE (idStore = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getAddress());
            stmt.setInt(3, obj.getReputation());
            stmt.setInt(4, obj.getCountry().getIdCountry());
            stmt.setInt(5, obj.getIdStore());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void delete(Store obj) {
        String sqlQuery = "DELETE FROM store WHERE (idStore = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getIdStore());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

}
