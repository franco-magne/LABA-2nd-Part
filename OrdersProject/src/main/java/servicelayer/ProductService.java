package servicelayer;

import dao.impl.ProductDAO;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean checkProductExists(String product) {
        return productDAO.getAll().stream()
                .anyMatch(c -> c.getName().equals(product));
    }
}
