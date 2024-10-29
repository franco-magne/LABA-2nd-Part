package servicelayer;

import dao.impl.UserDAO;
import model.User;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();
    //Logic regarding users

    public User getUser(int id) {
        return userDAO.getByID(id);
    }

    public List<User> listUser() {
        return userDAO.getAll();
    }

    public void createUser(User u) {
        userDAO.insert(u);
    }

    public void updateUser(User u) {
        userDAO.update(u);
    }

    public void deleteUser(User u) {
        userDAO.delete(u);
    }

}
