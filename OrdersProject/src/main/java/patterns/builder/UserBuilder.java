package patterns.builder;

import model.Country;
import model.User;

public class UserBuilder {
    private int idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private Country country;

    public int getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Country getCountry() {
        return country;
    }

    public UserBuilder idUser(int idUser) {
        this.idUser = idUser;
        return this;
    }

    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder country(Country country) {
        this.country = country;
        return this;
    }

    public User build() {
        User user = new User();

        user.setIdUser(getIdUser());
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setEmail(getEmail());
        user.setAddress(getAddress());
        user.setPhoneNumber(getPhoneNumber());
        user.setCountry(getCountry());

        return user;
    }

}
