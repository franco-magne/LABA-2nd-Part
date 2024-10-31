package patterns.builder;

import model.Country;
import model.Store;

public class StoreBuilder {
    private int idStore;
    private String name;
    private String address;
    private int reputation;
    private Country country;

    public int getIdStore() {
        return idStore;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getReputation() {
        return reputation;
    }

    public Country getCountry() {
        return country;
    }

    public StoreBuilder idStore(int idStore) {
        this.idStore = idStore;
        return this;
    }

    public StoreBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StoreBuilder address(String address) {
        this.address = address;
        return this;
    }

    public StoreBuilder reputation(int reputation) {
        this.reputation = reputation;
        return this;
    }

    public StoreBuilder country(Country country) {
        this.country = country;
        return this;
    }

    public Store build() {
        Store store = new Store();

        store.setIdStore(getIdStore());
        store.setName(getName());
        store.setAddress(getAddress());
        store.setReputation(getReputation());
        store.setCountry(getCountry());

        return store;
    }

}
