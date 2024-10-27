package servicelayer;

import dao.impl.UserDAO;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean checkUserExists(int userId) {
        return userDAO.getAll().stream()
                .anyMatch(c -> c.getIdUser() == userId);
    }
}

