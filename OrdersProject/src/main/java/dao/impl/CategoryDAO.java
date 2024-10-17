package dao.impl;

import dao.DAO;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO implements DAO<Category> {

    public CategoryDAO() {}

    @Override
    public Category getByID(int id) {
        String sqlQuery = "SELECT * FROM Category WHERE (idCategory = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Category(rs.getInt("idCategory"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Category";

        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                int idCategory = rs.getInt("idCategory");
                String name = rs.getString("name");

                categoryList.add(new Category(idCategory, name));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return categoryList;
    }

    @Override
    public void insert(Category obj) {
        String sqlQuery = "INSERT INTO Category(name) VALUES (?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(Category obj) {
        String sqlQuery = "UPDATE Category SET name = ? WHERE (idCategory = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getIdCategory());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void delete(Category obj) {
        String sqlQuery = "DELETE FROM Category WHERE (idCategory = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getIdCategory());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }
}
