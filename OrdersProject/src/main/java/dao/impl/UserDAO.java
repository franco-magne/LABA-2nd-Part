package dao.impl;

import dao.DAO;
import model.User;
import mybatis.UserMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements DAO<User> {

    @Override
    public User getByID(int id) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getByID(id);
        }
    }

    @Override
    public List<User> getAll() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(User user) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insert(user);
            session.commit();
        }
    }

    @Override
    public void update(User user) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.update(user);
            session.commit();
        }
    }

    @Override
    public void delete(User user) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.delete(user);
            session.commit();
        }
    }
}
