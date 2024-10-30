package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import patterns.decorator.ForeignUser;
import patterns.decorator.IUser;

@JsonRootName("user")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements IUser {
    private static final Logger logger = LogManager.getLogger(User.class);

    @JsonProperty("idUser")
    @XmlElement(name = "idUser")
    private int idUser;

    @JsonProperty("firstName")
    @XmlElement(name = "firstName")
    private String firstName;

    @JsonProperty("lastName")
    @XmlElement(name = "lastName")
    private String lastName;

    @JsonProperty("email")
    @XmlElement(name = "email")
    private String email;

    @JsonProperty("address")
    @XmlElement(name = "address")
    private String address;

    @JsonProperty("phoneNumber")
    @XmlElement(name = "phoneNumber")
    private String phoneNumber;

    @JsonProperty("country")
    @XmlElementRef(name = "country", type = Country.class)
    private Country country;
    private int idCountry;

    public User() {}

    public User(int idUser, String firstName, String lastName, String email, String address, String phoneNumber, Country country) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.idCountry = country.getIdCountry();
    }

    @Override
    public String toString() {
        return "User: { " +
                "idUser = " + idUser +
                ", first name = " + firstName +
                ", last name = " + lastName +
                ", email = " + email +
                ", address = " + address +
                ", phone number = " + phoneNumber +
                ", country = " + country.getName() + " }";
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Country getCountry() {
        return country;
    }

    public int getIdCountry() {return this.idCountry;}

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public void assemble() {
        logger.info("Assembling basic user details");
    }

    @Override
    public String getLocationType() {
        return "Undefined Location Type";
    }
}
