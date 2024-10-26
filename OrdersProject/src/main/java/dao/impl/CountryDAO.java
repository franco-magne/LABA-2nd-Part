package dao.impl;

import dao.DAO;
import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends AbstractDAO implements DAO<Country> {

    public CountryDAO() {}

    @Override
    public Country getByID(int id) {
        String sqlQuery = "SELECT * FROM country WHERE (idCountry = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Country(
                        rs.getInt("idCountry"),
                        rs.getString("name")
                );
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Country> getAll() {
        List<Country> countryList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM country";

        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                countryList.add(new Country(
                        rs.getInt("idCountry"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return countryList;
    }

    @Override
    public void insert(Country obj) {
        String sqlQuery = "INSERT INTO country (name) VALUES (?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(Country obj) {
        String sqlQuery = "UPDATE country SET name = ? WHERE (idCountry = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getIdCountry());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void delete(Country obj) {
        String sqlQuery = "DELETE FROM country WHERE (idCountry = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getIdCountry());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }
}
