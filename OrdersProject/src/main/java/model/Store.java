package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.*;

@JsonRootName("store")
@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
public class Store {

    @JsonProperty("idStore")
    @XmlElement(name = "idStore")
    private int idStore;

    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;

    @JsonProperty("address")
    @XmlElement(name = "address")
    private String address;

    @JsonProperty("reputation")
    @XmlElement(name = "reputation")
    private int reputation;

    @JsonProperty("country")
    @XmlElementRef(name = "country", type = Country.class)
    private Country country;

    public Store() {}

    public Store(int idStore, String name, String address, int reputation, Country country) {
        this.idStore = idStore;
        this.name = name;
        this.address = address;
        this.reputation = reputation;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Store: { " +
                "idStore = " + idStore +
                ", name = " + name +
                ", address = " + address +
                ", reputation = " + reputation +
                ", country = " + country.getName() + " }";
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
