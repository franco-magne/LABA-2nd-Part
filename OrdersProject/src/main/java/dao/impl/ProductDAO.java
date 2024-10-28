package dao.impl;

import dao.DAO;
import model.Product;
import mybatis.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO implements DAO<Product> {

    @Override
    public Product getByID(int id) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            return mapper.getByID(id);
        }
    }

    @Override
    public List<Product> getAll() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Product product) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.insert(product);
            session.commit();
        }
    }

    @Override
    public void update(Product product) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.update(product);
            session.commit();
        }
    }

    @Override
    public void delete(Product product) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            ProductMapper mapper = session.getMapper(ProductMapper.class);
            mapper.delete(product);
            session.commit();
        }
    }

}
