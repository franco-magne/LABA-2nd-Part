package servicelayer;

import dao.impl.CountryDAO;
import dao.impl.UserDAO;
import model.User;
import patterns.decorator.ForeignUser;
import patterns.decorator.IUser;
import patterns.decorator.LocalUser;

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

    public IUser getUserWithLocation(int id) {
        User user = userDAO.getByID(id);
        CountryDAO countryDAO = new CountryDAO();
        String country = countryDAO.getByID(user.getIdCountry()).getName();
        return  ("Argentina".equalsIgnoreCase(country) ) ? new LocalUser(user):new ForeignUser(user);
    }

}
