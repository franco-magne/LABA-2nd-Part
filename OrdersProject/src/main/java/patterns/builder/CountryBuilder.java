package patterns.builder;

import model.Country;

public class CountryBuilder {
    private int idCountry;
    private String name;

    public int getIdCountry() {
        return idCountry;
    }

    public String getName() {
        return name;
    }

    public CountryBuilder setIdCountry(int idCountry) {
        this.idCountry = idCountry;
        return this;
    }

    public CountryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Country build() {
        Country country = new Country();

        country.setIdCountry(getIdCountry());
        country.setName(getName());

        return country;
    }

}
