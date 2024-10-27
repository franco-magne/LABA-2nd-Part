package dao.impl;

import dao.DAO;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO implements DAO<Product> {

    public ProductDAO() {}

    @Override
    public Product getByID(int id) {
        String sqlQuery = "SELECT * FROM product WHERE (idProduct = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(
                    rs.getInt("idProduct"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getInt("stock"),
                    new CategoryDAO().getByID(rs.getInt("idCategory")),
                    new StoreDAO().getByID(rs.getInt("idStore"))
                );
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM product";

        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            while (rs.next()) {
                productList.add(new Product(
                    rs.getInt("idProduct"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getInt("stock"),
                    new CategoryDAO().getByID(rs.getInt("idCategory")),
                    new StoreDAO().getByID(rs.getInt("idStore"))
                ));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return productList;
    }

    @Override
    public void insert(Product obj) {
        String sqlQuery = "INSERT INTO product (name, description, price, stock, idCategory, idStore) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getDescription());
            stmt.setDouble(3, obj.getPrice());
            stmt.setInt(4, obj.getStock());
            stmt.setInt(5, obj.getCategory().getIdCategory());
            stmt.setInt(6, obj.getStore().getIdStore());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(Product obj) {
        String sqlQuery = "UPDATE product SET name = ?, description = ?, price = ?, stock = ?, idCategory = ?, " +
                "idStore = ? WHERE (idProduct = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getDescription());
            stmt.setDouble(3, obj.getPrice());
            stmt.setInt(4, obj.getStock());
            stmt.setInt(5, obj.getCategory().getIdCategory());
            stmt.setInt(6, obj.getStore().getIdStore());
            stmt.setInt(7, obj.getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void delete(Product obj) {
        String sqlQuery = "DELETE FROM product WHERE (idProduct = ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQuery)) {
            stmt.setInt(1, obj.getIdProduct());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

}
