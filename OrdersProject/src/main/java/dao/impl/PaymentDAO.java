package dao.impl;

import dao.DAO;
import model.Payment;
import mybatis.PaymentMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;
import java.util.List;

public class PaymentDAO extends AbstractDAO implements DAO<Payment> {
    @Override
    public Payment getByID(int id) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            return mapper.getByID(id);
        }
    }

    @Override
    public List<Payment> getAll() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void insert(Payment payment) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            mapper.insert(payment);
            session.commit();
        }
    }

    @Override
    public void update(Payment payment) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            mapper.update(payment);
            session.commit();
        }
    }

    @Override
    public void delete(Payment payment) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PaymentMapper mapper = session.getMapper(PaymentMapper.class);
            mapper.delete(payment);
            session.commit();
        }
    }

}
