package servicelayer;

import dao.impl.ProductDAO;
import model.Product;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();
    //Logic regarding products

    public Product getProduct(int id) {
        return productDAO.getByID(id);
    }

    public List<Product> listProduct() {
        return productDAO.getAll();
    }

    public void createProduct(Product p) {
        productDAO.insert(p);
    }

    public void updateProduct(Product p) {
        productDAO.update(p);
    }

    public void deleteProduct(Product p) {
        productDAO.delete(p);
    }
}
