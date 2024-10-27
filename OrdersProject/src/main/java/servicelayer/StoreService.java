package servicelayer;

import dao.impl.StoreDAO;

public class StoreService {
    private final StoreDAO storeDAO;

    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public boolean checkStoreExists(String store) {
        return storeDAO.getAll().stream()
                .anyMatch(c -> c.getName().equals(store));
    }
}

