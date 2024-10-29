package dao.impl;

import dao.DAO;
import model.Country;
import mybatis.CountryMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;
import java.util.List;

public class CountryDAO extends AbstractDAO implements DAO<Country> {

    @Override
    public Country getByID(int id) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            return mapper.getByID(id);
        }
    }

    @Override
    public List<Country> getAll() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Country country) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            mapper.insert(country);
            session.commit();
        }
    }

    @Override
    public void update(Country country) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            mapper.update(country);
            session.commit();
        }
    }

    @Override
    public void delete(Country country) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            mapper.delete(country);
            session.commit();
        }
    }

}
