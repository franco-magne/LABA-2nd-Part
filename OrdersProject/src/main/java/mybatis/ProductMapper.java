package mybatis;

import model.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM product WHERE (idProduct = #{idProduct})")
    Product getByID(int id);

    @Select("SELECT * FROM product")
    List<Product> getAll();

    @Insert("INSERT INTO product (name, description, price, stock, idCategory, idStore) VALUES (#{name}, #{description}, " +
            "#{price}, #{stock}, #{idCategory}, #{idStore})")
    void insert(Product product);

    @Update("UPDATE product SET name = #{name}, description = #{description}, price = #{price}, stock = #{stock}, " +
            "idCategory = #{idCategory}, idStore = #{idStore} WHERE (idProduct = #{idProduct})")
    void update(Product product);

    @Delete("DELETE FROM product WHERE (idProduct = #{idProduct})")
    void delete(Product product);

}
