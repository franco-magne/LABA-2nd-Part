package servicelayer;

import dao.impl.CategoryDAO;

public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public boolean checkCategoryExists(String category) {
        return categoryDAO.getAll().stream()
                .anyMatch(c -> c.getName().equals(category));
    }
}
