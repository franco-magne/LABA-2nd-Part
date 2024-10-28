package servicelayer;

import dao.impl.StoreDAO;
import model.Country;
import model.Store;
import model.Store;
import mybatis.StoreMapper;
import mybatis.StoreMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.util.List;

public class StoreService {
    private final StoreDAO storeDAO = new StoreDAO();
    //Logic regarding stores

    public Store getStore(int id){
        return storeDAO.getByID(id);
    }

    public List<Store> listStore(){
        return storeDAO.getAll();
    }

    public void createStore(int idStore, String name, String address, int reputation, Country country){
        Store s = new Store(idStore, name ,address, reputation, country);
        storeDAO.insert(s);
    }

    public void updateStore(Store s){
        storeDAO.update(s);
    }

    public void deleteStore(Store s){
        storeDAO.delete(s);
    }
}

