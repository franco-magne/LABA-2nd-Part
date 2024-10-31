package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import patterns.builder.CountryBuilder;

@JsonRootName("country")
@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {

    @JsonProperty("idCountry")
    @XmlElement(name = "idCountry") //edit: it was "idCategory"
    private int idCountry;

    @JsonProperty("name")
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

    public static CountryBuilder builder() {
        return new CountryBuilder();
    }

}
