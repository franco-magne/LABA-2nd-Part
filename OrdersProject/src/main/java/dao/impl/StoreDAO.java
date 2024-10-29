package dao.impl;

import dao.DAO;
import model.Store;
import mybatis.StoreMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;
import java.util.List;

public class StoreDAO extends AbstractDAO implements DAO<Store> {

    @Override
    public Store getByID(int id) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            return mapper.getByID(id);
        }
    }

    @Override
    public List<Store> getAll() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Store store) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            mapper.insert(store);
            session.commit();
        }
    }

    @Override
    public void update(Store store) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            mapper.update(store);
            session.commit();
        }
    }

    @Override
    public void delete(Store store) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            StoreMapper mapper = session.getMapper(StoreMapper.class);
            mapper.delete(store);
            session.commit();
        }
    }

}
