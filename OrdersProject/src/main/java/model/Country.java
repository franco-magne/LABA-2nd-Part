package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {

    @XmlElement(name = "idCategory")
    private int idCountry;

    @XmlElement(name = "name")
    private String name;

    public Country() {}

    public Country(int idCountry, String name) {
        this.idCountry = idCountry;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country: { " +
                "idCountry = " + idCountry +
                ", name = " + name + " }";
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}