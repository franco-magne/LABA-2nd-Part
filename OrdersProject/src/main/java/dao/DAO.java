package dao;

import java.util.List;

public interface DAO<T> {
    T getByID(int id);
    List<T> getAll();
    void insert(T obj);
    void update(T obj);
    void delete(T obj);

}
