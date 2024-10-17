package dao;

import java.util.List;

/*
    1. Create DAO classes with necessary interfaces, abstract classes, and Generics.  DAO should be scalable and flexible to support another
    framework and another database as well. All CRUD operations should be supported using JDBC. Use connection pool from the below block.
    2. Implement Service Layer with necessary abstraction to be able to switch between databases and frameworks

    1. Create one XML file and XSD schema for at least 5 classes from the below hierarchy.
    2. Validate XML file using XSD schema and assigned parser.
    3. Parse XML file using one of the parsers from the past lectures.

    2. Add JAXB annotations to the hierarchy. Date, List, and complex objects should be covered.
    3. Parse XML using JAXB.
* */

public interface DAO<T> {
    T getByID(int id);
    List<T> getAll();
    void insert(T obj);
    void update(T obj);
    void delete(T obj);

}
