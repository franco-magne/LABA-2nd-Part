package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlElement(name = "idCategory")
    private int idCategory;

    @XmlElement(name = "name")
    private String name;

    public Category() {}

    public Category(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category: { " +
                "idCategory = " + idCategory +
                ", name = " + name + " }";
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
