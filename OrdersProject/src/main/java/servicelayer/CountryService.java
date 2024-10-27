package servicelayer;

import dao.impl.CountryDAO;

public class CountryService {
    private final CountryDAO countryDAO;

    public CountryService(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public boolean checkCountryExists(String country) {
        return countryDAO.getAll().stream()
                .anyMatch(c -> c.getName().equals(country));
    }
}

