package dao.impl;

import dao.DAO;
import model.Category;
import mybatis.CategoryMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO implements DAO<Category> {

    @Override
    public Category getByID(int id) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getByID(id);
        }
    }

    @Override
    public List<Category> getAll() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Category category) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.insert(category);
            session.commit();
        }
    }

    @Override
    public void update(Category category) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.update(category);
            session.commit();
        }
    }

    @Override
    public void delete(Category category) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.delete(category);
            session.commit();
        }
    }

}
