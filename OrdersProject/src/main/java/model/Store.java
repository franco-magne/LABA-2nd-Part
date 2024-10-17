package model;

public class Store {
    private int idStore;
    private String name;
    private String address;
    private int reputation;
    private Country country;

    public Store(int idStore, String name, String address, int reputation, Country country) {
        this.idStore = idStore;
        this.name = name;
        this.address = address;
        this.reputation = reputation;
        this.country = country;
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
