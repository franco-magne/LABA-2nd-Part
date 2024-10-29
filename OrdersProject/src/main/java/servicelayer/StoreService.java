package servicelayer;

import dao.impl.StoreDAO;
import model.Store;
import java.util.List;

public class StoreService {
    private final StoreDAO storeDAO = new StoreDAO();
    //Logic regarding stores

    public Store getStore(int id) {
        return storeDAO.getByID(id);
    }

    public List<Store> listStore() {
        return storeDAO.getAll();
    }

    public void createStore(Store s) {
        storeDAO.insert(s);
    }

    public void updateStore(Store s) {
        storeDAO.update(s);
    }

    public void deleteStore(Store s) {
        storeDAO.delete(s);
    }
}

