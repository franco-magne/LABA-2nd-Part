package dao.impl;

import dao.DAO;
import model.Order;
import model.Product;
import mybatis.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractDAO implements DAO<Order> {

    @Override
    public Order getByID(int id) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            return mapper.getByID(id);
        }
    }

    @Override
    public List<Order> getAll() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            return mapper.getAll();
        }
    }
    @Override
    public void insert(Order order) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            mapper.insert(order);
            session.commit();
        }
    }

    @Override
    public void update(Order order) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            mapper.update(order);
            session.commit();
        }
    }

    @Override
    public void delete(Order order) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            mapper.delete(order);
            session.commit();
        }
    }

}
