package servicelayer;

import model.Country;
import dao.impl.CountryDAO;

import java.util.List;

public class CountryService {

    private final CountryDAO countryDAO = new CountryDAO();
    //Logic regarding countries

    public Country getCountry(int id){
        return countryDAO.getByID(id);
    }

    public List<Country> listCountry(){
        return countryDAO.getAll();
    }

    public void createCountry(int idCountry, String name){
        Country c = new Country(idCountry, name);
        countryDAO.insert(c);
    }

    public void updateCountry(Country c){
        countryDAO.update(c);
    }

    public void deleteCountry(Country c){
        countryDAO.delete(c);
    }
}
