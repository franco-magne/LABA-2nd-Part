package servicelayer;

import model.Category;
import dao.impl.CategoryDAO;
import java.util.List;

public class CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();
    // Logic regarding categories

    public Category getCategory(int id) {
        return categoryDAO.getByID(id);
    }

    public List<Category> listCategory() {
        return categoryDAO.getAll();
    }

    public void createCategory(Category c) {
        categoryDAO.insert(c);
    }

    public void updateCategory(Category c) {
        categoryDAO.update(c);
    }

    public void deleteCategory(Category c) {
        categoryDAO.delete(c);
    }
}
